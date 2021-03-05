package mf.arduino.arduinomonitor.services.pdfexport;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import mf.arduino.arduinomonitor.model.Lights;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class LightsPDFexporter {

    private List<Lights> lightsListExport;

    public LightsPDFexporter(List<Lights> lightsListExport) {
        this.lightsListExport = lightsListExport;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GREEN);
        cell.setPadding(3);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.white);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("light level", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("timestamp", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable pdfPTable) {
        for (Lights lights : lightsListExport) {
            pdfPTable.addCell(String.valueOf(lights.getId()));
            pdfPTable.addCell(String.valueOf(lights.getLightLevel()));
            pdfPTable.addCell(String.valueOf(lights.getTimestamp()));
        }

    }

    public void export(HttpServletResponse response) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(15);
        font.setColor(Color.BLUE);

        Paragraph paragraph = new Paragraph("List of sensors data", font);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {4.0f, 4.0f, 6.0f});
        table.setSpacingBefore(5);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.close();
    }
}
