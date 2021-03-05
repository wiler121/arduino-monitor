package mf.arduino.arduinomonitor.services.pdfexport;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import mf.arduino.arduinomonitor.model.Sensor;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class SensorPDFexporter {
    private List<Sensor> sensorListExport;

    public SensorPDFexporter(List<Sensor> sensorListExport) {
        this.sensorListExport = sensorListExport;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GREEN);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.white);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("temperature", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("humidity", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("co2", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("timestamp", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable pdfPTable){
        for (Sensor sensor : sensorListExport){
            pdfPTable.addCell(String.valueOf(sensor.getId()));
            pdfPTable.addCell(String.valueOf(sensor.getTemperature()));
            pdfPTable.addCell(String.valueOf(sensor.getHumidity()));
            pdfPTable.addCell(String.valueOf(sensor.getCo2()));
            pdfPTable.addCell(String.valueOf(sensor.getTimestamp()));
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

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.0f, 2.0f, 2.0f, 2.0f, 5.0f});
        table.setSpacingBefore(5);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.close();
    }
}
