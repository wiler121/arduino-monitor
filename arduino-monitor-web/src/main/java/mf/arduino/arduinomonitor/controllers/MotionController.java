package mf.arduino.arduinomonitor.controllers;

import com.lowagie.text.DocumentException;
import mf.arduino.arduinomonitor.model.Motion;
import mf.arduino.arduinomonitor.services.map.MotionMapService;
import mf.arduino.arduinomonitor.services.pdfexport.MotionPDFexporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/sensorsPages")
@Controller
public class MotionController {

    @Autowired
    private MotionMapService motionMapService;



    @GetMapping("/motion")
    public String viewHomePage(Model model) {
        return findPaginated(1, "id", "desc", model);
    }

    @RequestMapping({"/motion/page/{pageNo}"})
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize = 200;

        Page<Motion> page = motionMapService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<Motion> motionList = page.getContent();

        model.addAttribute("currentPage", pageNo );
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements() );

        model.addAttribute("sortField", sortField );
        model.addAttribute("sortDir", sortDir );
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");

        model.addAttribute("motionList", motionList );

        return "sensorsPages/motion";

    }

    @GetMapping({"/motion/page/{pageNo}/exportPdf"})
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormattter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

        String currentDatetime = dateFormattter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=motionData_"+currentDatetime+".pdf";

        List<Motion> motionDataList = motionMapService.listAll();

        MotionPDFexporter motionPDFexporter = new MotionPDFexporter(motionDataList);
        motionPDFexporter.export(response);
    }



}
