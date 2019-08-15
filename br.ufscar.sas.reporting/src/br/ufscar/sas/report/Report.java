package br.ufscar.sas.report;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;

public class Report {

	public void create(String projectPath, String projectName, String currentPath, String plannedPath)  {

		XWPFDocument doc = new XWPFDocument();

		//Title
		XWPFParagraph title= doc.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		title.setWordWrapped(true);
		title.setStyle("Heading2");

		XWPFRun r1 = title.createRun();
		r1.setBold(true);
		r1.setColor("17365d");
		String t1 = "Architectural Report of " + projectName + " Project" ;
		r1.setText(t1);
		r1.addBreak();
		
		//Section 1
		XWPFParagraph section1 = doc.createParagraph();
		section1.setStyle("Heading7");
		
		r1 = section1.createRun();
		r1.setBold(true);
		r1.setColor("17365d");
		t1 = "Architectural Diagrams" ;
		r1.setText(t1);
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


}

