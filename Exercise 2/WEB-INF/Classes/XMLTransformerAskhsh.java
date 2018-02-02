import java.io.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.*;
// for servlet:
import javax.servlet.*;
import javax.servlet.http.*;
import org.w3c.dom.*; // for DOM (Java DOM)
import javax.xml.parsers.*;
import javax.xml.transform.dom.*;// for transformations

public class XMLTransformerAskhsh extends HttpServlet {
	ServletContext ctx;
	String absPath;
	TransformerFactory tF;
	Transformer myTransformer;// will be built at init, will be used by doGet
	Document doc, my_doc;								

	public void init(ServletConfig config) throws UnavailableException {
		try {
			ctx = config.getServletContext(); // we will use the 'contex' below
			absPath = ctx.getRealPath("/WEB-INF/Styling.xsl");
			tF = TransformerFactory.newInstance();
			DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
			fact.setNamespaceAware(true);
			DocumentBuilder builder = fact.newDocumentBuilder();
			doc = builder.parse(absPath);
			my_doc = (Document) doc.cloneNode(true);			
		} catch (Exception e) {e.printStackTrace(); }
	}
	
	/*Kanw allages sto keimeno: xrwma backround, keimeno, 8esi*/
	private void changeMyDom(Document doc, String back_color,String color, String align) {
		NodeList nl = doc.getElementsByTagName("h1");
		Attr a = doc.createAttribute("style");
		a.setValue("background-color: "+back_color+"; color:"+color+ ";text-align:"+align);
		nl.item(0).getAttributes().setNamedItem(a);
	}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i;
		Element element;
		//pairnoume me get ta orismata/epiloges tou xristi
		String back_color = request.getParameter("back_color");
		String color = request.getParameter("color");
		String align = request.getParameter("align");
		String type = request.getParameter("type");
		String xsl_type = request.getParameter("xsl_type");
		
		doc = (Document) my_doc.cloneNode(true);
				
		
		
		
		changeMyDom(doc, back_color,color,align);

		PrintWriter pwr = response.getWriter();	
		try {
			DOMSource ds = new DOMSource(doc) ;
			myTransformer = tF.newTransformer(ds);
			StreamSource xmlSource = new StreamSource(ctx.getResourceAsStream("/WEB-INF/"+type+".xml"));
			response.setContentType("text/html"); //in order to put in http body
			myTransformer.transform(xmlSource, new StreamResult(pwr));
			pwr.println( "<FORM ACTION='ex2' METHOD='GET'>" );
			pwr.println("<br/>");
			pwr.println( "<center><INPUT TYPE='submit' VALUE='return'></center>" );
			pwr.println( "</FORM>" );
			pwr.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		PrintWriter output;
		response.setContentType( "text/html" );
		output = response.getWriter();
		
		output.println( "<HTML><HEAD><TITLE>exercise2</TITLE> </HEAD><BODY>" );
		output.println( "<FORM ACTION='ex2' METHOD='POST'>" );
		output.println( "<center><p><font size='30' ><b> Exercise 2 </b></font> </p>" );
		output.println( "<p ><b> Please choose the backround color of the title: </b></p> " );
		output.println( "<input type='radio' name='back_color' value='#FF3366' required checked>Pink<br>" );
		output.println( "<input type='radio' name='back_color' value='#FF6633' required>Orange<br> " );
		output.println( "<input type='radio' name='back_color' value='#336633' required>Green<br> " );
		output.println( "<input type='radio' name='back_color' value='#FFFF33' required>Yellow<br> " );
		output.println( "<p ><b> Please choose the letters' color of the title: </b></p> " );
		output.println( "<input type='radio' name='color' value='#FFFFFF' required checked>White<br>" );
		output.println( "<input type='radio' name='color' value='#0033CC' required>Blue<br> " );
		output.println( "<input type='radio' name='color' value='#000000' required>Black<br> " );
		output.println( "<p ><b> Please choose the position of the title: </b></p> " );
		output.println( "<input type='radio' name='align' value='center' required checked>Center<br>" );
		output.println( "<input type='radio' name='align' value='left' required>Left<br> " );
		output.println( "<input type='radio' name='align' value='right' required>Right<br> " );
		output.println( "<p ><b> Please choose what you want to see: </b></p> " );
		output.println( "<input type='radio' name='type' value='Cars' required checked>Used Vehicles<br>" );
		output.println( "<input type='radio' name='type' value='Boats' required>Old Boats<br> " );
		output.println( "<input type='radio' name='type' value='Airplanes' required>Private Airplanes<br> " );
		output.println("<br/>");
		output.println( "<input type='submit' value='Submit' id = 'submit' /> </center> " );
		output.println( "</FORM>");
		output.println( "</BODY></HTML>" );
		output.close(); // close stream
	}
}
