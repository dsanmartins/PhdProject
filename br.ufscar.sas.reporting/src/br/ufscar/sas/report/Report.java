package br.ufscar.sas.report;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.draw.binding.CTColor;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;

import br.ufscar.sas.dataconstraint.DataConstraint;
import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;

public class Report {

	public void create(String projectPath, String projectName, String currentPath, String plannedPath, DataConstraint constraintData) throws Exception  {

		XWPFDocument doc = new XWPFDocument();
		//Title
		XWPFParagraph title= doc.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		title.setWordWrapped(true);
		title.setStyle("Heading1");
		title.setBorderBottom(Borders.SINGLE);


		XWPFRun r1 = title.createRun();
		r1.setBold(true);
		r1.setColor("17365d");
		String t1 = "Architectural Report of " + projectName + " Project" ;
		r1.setText(t1);
		r1.setFontFamily("Verdana");
		r1.addBreak();

		//Section 1
		XWPFParagraph section1 = doc.createParagraph();
		section1.setStyle("Heading7");

		r1 = section1.createRun();
		r1.setBold(true);
		r1.setColor("17365d");
		t1 = "Architectural Diagrams" ;
		r1.setText(t1);
		r1.setFontFamily("Verdana");
		r1.setFontSize(12);
		r1.addBreak();
		r1.addBreak();

		try {
			File currentFile = new File(currentPath + "ComponentDiagram.txt");
			InputStream currentStream = getFigure(currentFile);
			File plannedFile = new File(plannedPath + "ComponentDiagram.txt");
			InputStream plannedStream = getFigure(plannedFile);
			BufferedImage imgCurrent = ImageIO.read(currentStream);
			BufferedImage imgPlanned = ImageIO.read(plannedStream);
			double width = imgCurrent.getWidth();
			double height = imgCurrent.getHeight();
			double scaling = 1.0;
			if (width > 72*6) scaling = (72*6)/width;
			currentStream.close();
			currentStream = getFigure(currentFile);
			r1.addPicture(currentStream, XWPFDocument.PICTURE_TYPE_JPEG, "Current Architecture",  Units.toEMU(width*scaling), Units.toEMU(height*scaling));
			r1.addBreak();
			r1.addBreak();
			width = imgPlanned.getWidth();
			height = imgPlanned.getHeight();
			scaling = 1.0;
			if (width > 72*6) scaling = (72*6)/width;

			plannedStream.close();
			plannedStream = getFigure(plannedFile);
			r1.addPicture(plannedStream, XWPFDocument.PICTURE_TYPE_JPEG, "Planned Architecture",  Units.toEMU(width*scaling), Units.toEMU(height*scaling));

		} catch (InvalidFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		XWPFParagraph section2 = doc.createParagraph();
		section2.setPageBreak(true);

		r1 = section2.createRun();
		r1.setBold(true);
		r1.setColor("17365d");
		t1 = "Rules for Checking Conformance" ;
		r1.setText(t1);
		r1.setFontFamily("Verdana");
		r1.setFontSize(12);
		r1.addBreak();
		r1.addBreak();

		List<String> existenceRules = constraintData.getExistenceRules();
		XWPFTable table = doc.createTable(existenceRules.size()+2,3);
		//create first row
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("Existence of Abstractions");
		tableRowOne.getCell(1).setText("");
		tableRowOne.getCell(2).setText("");

		XWPFTableRow tableRowTwo = table.getRow(1);
		tableRowTwo.getCell(0).setText("Rule ID");
		tableRowTwo.getCell(1).setText("OCL Rule");
		tableRowTwo.getCell(2).setText("Result");
		XWPFParagraph paragraph = tableRowTwo.getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun run = paragraph.createRun();
		run.setBold(true);
		paragraph = tableRowTwo.getCell(1).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);
		paragraph = tableRowTwo.getCell(2).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);


		for (int i=0; i< existenceRules.size(); i++)
		{
			XWPFTableRow row = table.getRow(i+2);
			if (existenceRules.get(i).split(Pattern.quote(","))[2].equals("0"))
			{
				row.getCell(0).setText(existenceRules.get(i).split(Pattern.quote(","))[0]);
				row.getCell(0).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
				row.getCell(1).setText(existenceRules.get(i).split(Pattern.quote(","))[1]);
				row.getCell(1).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
				row.getCell(2).setText(existenceRules.get(i).split(Pattern.quote(","))[2]);
				row.getCell(2).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
			}
			else {
				row.getCell(0).setText(existenceRules.get(i).split(Pattern.quote(","))[0]);
				row.getCell(1).setText(existenceRules.get(i).split(Pattern.quote(","))[1]);
				row.getCell(2).setText(existenceRules.get(i).split(Pattern.quote(","))[2]);
			}
		}

		this.mergeCellHorizontally(table, 0, 0, 2);
		paragraph = tableRowOne.getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);

		//-----------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------

		XWPFParagraph section3 = doc.createParagraph();
		section3.setPageBreak(true);

		List<String> compositeRule = constraintData.getCompositeRules();
		table = doc.createTable(compositeRule.size()+2,3);
		//create first row
		tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("Composition of Abstractions");
		tableRowOne.getCell(1).setText("");
		tableRowOne.getCell(2).setText("");

		tableRowTwo = table.getRow(1);
		tableRowTwo.getCell(0).setText("Rule ID");
		tableRowTwo.getCell(1).setText("OCL Rule");
		tableRowTwo.getCell(2).setText("Result");
		paragraph = tableRowTwo.getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);
		paragraph = tableRowTwo.getCell(1).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);
		paragraph = tableRowTwo.getCell(2).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);


		for (int i=0; i< compositeRule.size(); i++)
		{
			XWPFTableRow row = table.getRow(i+2);
			if (compositeRule.get(i).split(Pattern.quote(","))[2].equals("0"))
			{
				row.getCell(0).setText(compositeRule.get(i).split(Pattern.quote(","))[0]);
				row.getCell(0).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
				row.getCell(1).setText(compositeRule.get(i).split(Pattern.quote(","))[1]);
				row.getCell(1).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
				row.getCell(2).setText(compositeRule.get(i).split(Pattern.quote(","))[2]);
				row.getCell(2).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
			}
			else {
				row.getCell(0).setText(compositeRule.get(i).split(Pattern.quote(","))[0]);
				row.getCell(1).setText(compositeRule.get(i).split(Pattern.quote(","))[1]);
				row.getCell(2).setText(compositeRule.get(i).split(Pattern.quote(","))[2]);
			}
		}

		this.mergeCellHorizontally(table, 0, 0, 2);
		paragraph = tableRowOne.getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);

		//-----------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------

		XWPFParagraph section4 = doc.createParagraph();
		section4.setPageBreak(true);

		List<String> accessRule = constraintData.getAccessRules();
		table = doc.createTable(accessRule.size()+2,3);
		//create first row
		tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("Access of Abstractions");
		tableRowOne.getCell(1).setText("");
		tableRowOne.getCell(2).setText("");

		tableRowTwo = table.getRow(1);
		tableRowTwo.getCell(0).setText("Rule ID");
		tableRowTwo.getCell(1).setText("OCL Rule");
		tableRowTwo.getCell(2).setText("Result");
		paragraph = tableRowTwo.getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);
		paragraph = tableRowTwo.getCell(1).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);
		paragraph = tableRowTwo.getCell(2).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);


		for (int i=0; i< accessRule.size(); i++)
		{
			XWPFTableRow row = table.getRow(i+2);
			if (accessRule.get(i).split(Pattern.quote(","))[2].equals("0"))
			{
				row.getCell(0).setText(accessRule.get(i).split(Pattern.quote(","))[0]);
				row.getCell(0).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
				row.getCell(1).setText(accessRule.get(i).split(Pattern.quote(","))[1]);
				row.getCell(1).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
				row.getCell(2).setText(accessRule.get(i).split(Pattern.quote(","))[2]);
				row.getCell(2).getCTTc().addNewTcPr().addNewShd().setFill("f9e79f");
			}
			else {
				row.getCell(0).setText(accessRule.get(i).split(Pattern.quote(","))[0]);
				row.getCell(1).setText(accessRule.get(i).split(Pattern.quote(","))[1]);
				row.getCell(2).setText(accessRule.get(i).split(Pattern.quote(","))[2]);
			}
		}

		this.mergeCellHorizontally(table, 0, 0, 2);
		paragraph = tableRowOne.getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);


		XWPFParagraph section5 = doc.createParagraph();
		section5.setPageBreak(true);

		r1 = section5.createRun();
		r1.setBold(true);
		r1.setColor("17365d");
		t1 = "Architectural Anomalies Identified" ;
		r1.setText(t1);
		r1.setFontFamily("Verdana");
		r1.setFontSize(12);
		r1.addBreak();
		r1.addBreak();

		List<String> anomalies = constraintData.getAnomaliesIdentifiedReport();
		table = doc.createTable(anomalies.size()+1,2);

		tableRowOne = table.getRow(0);
	
		tableRowOne.getCell(0).getCTTc().addNewTcPr().addNewShd().setFill("e67e22");
		tableRowOne.getCell(1).getCTTc().addNewTcPr().addNewShd().setFill("e67e22");
		
		paragraph = tableRowOne.getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);
		run.setColor("ffffff");
		run.setText("Rule");
		
		paragraph = tableRowOne.getCell(1).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setBold(true);
		run.setColor("ffffff");
		run.setText("Anomaly");
		

		for (int i=0; i< anomalies.size(); i++)
		{
			XWPFTableRow row = table.getRow(i+1);
			row.getCell(0).setText(anomalies.get(i).split(Pattern.quote("|"))[0]);
			row.getCell(1).setText(anomalies.get(i).split(Pattern.quote("|"))[1]);
		}


		FileOutputStream fo = null;

		try {
			// create .docx file
			fo = new FileOutputStream(projectPath + projectName + ".docx");
			// write to the .docx file
			doc.write(fo);
		} catch (IOException e) {
		} finally {
			if (fo != null) {
				try {
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (doc != null) {
				try {
					doc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public InputStream getFigure(File source) throws IOException {

		SourceFileReader reader = null;
		List<GeneratedImage> list = null;
		reader = new SourceFileReader(source);
		list = reader.getGeneratedImages();
		File file = list.get(0).getPngFile();
		InputStream targetStream = new FileInputStream(file);
		return targetStream;
	}

	public Dimension getImageDimension(File imgFile) throws IOException {
		BufferedImage img = ImageIO.read(imgFile);
		return new Dimension(img.getWidth(), img.getHeight());
	}

	//merging horizontally by setting grid span instead of using CTHMerge
	public void mergeCellHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
		XWPFTableCell cell = table.getRow(row).getCell(fromCol);
		// Try getting the TcPr. Not simply setting an new one every time.
		CTTcPr tcPr = cell.getCTTc().getTcPr();
		if (tcPr == null) tcPr = cell.getCTTc().addNewTcPr();
		// The first merged cell has grid span property set
		if (tcPr.isSetGridSpan()) {
			tcPr.getGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
		} else {
			tcPr.addNewGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
		}
		// Cells which join (merge) the first one, must be removed
		for(int colIndex = toCol; colIndex > fromCol; colIndex--) {
			table.getRow(row).getCtRow().removeTc(colIndex);
			table.getRow(row).removeCell(colIndex);
		}
	}


}

