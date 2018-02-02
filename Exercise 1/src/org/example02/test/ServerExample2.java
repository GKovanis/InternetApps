package org.example02.test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ServerExample2 extends HttpServlet {
	
	private String CPUa[]= {"AMD Ryzen x1600 3.00 GHz","Intel Core i5 6200U 2.40 GHz ","AMD Ryzen x1800 4.00 GHz","Intel Core i7 6700U 3.40 GHz"};
	private double CostCPUa[]= {229,250,500,1000};
	private String RAMa[]= {"8 GB DDR4 2133 MHz","8 GB DDR4 2600 MHz","16 GB DDR4 2133 MHz","16 GB DDR4 3200 MHz"};
	private double CostRAMa[]={80,120,160,250};
	private String HardDrivesa[]={"256 GB SSD","500 GB SSD","1 TB HDD + 256 GB SSD","2 TB HDD + 500 GB SSD"};
	private double CostHardDrivesa[]={120,180,190,280};
	
	
	  public void doPost( HttpServletRequest req,        // reaction to the reception of POST
              HttpServletResponse resp )   throws ServletException, IOException
{	//initializing Cookies' values
    String RAM="";
    String CostRAM="";
	String username="";
	String email="";
    String CostCPU="";
    String CPU="";
    String HardDrives="";
    String CostHardDrives="";
    double TotalCost=0;
    double lala=0;
    Boolean flag = false;
    
    //getting the user's chosen items from cookies
    Cookie CPUcookie = new Cookie("CPU", req.getParameter("CPU"));
  	CPUcookie.setMaxAge(1200);
  	resp.addCookie( CPUcookie );
  	CPU = CPUcookie.getValue();
  	Cookie RAMcookie = new Cookie("RAM", req.getParameter("RAM"));
    RAMcookie.setMaxAge(1200);
  	resp.addCookie( RAMcookie );
  	RAM = RAMcookie.getValue();
  	Cookie HardDrivescookie = new Cookie("HardDrives", req.getParameter("HardDrives"));
  	HardDrivescookie.setMaxAge(1200);
  	resp.addCookie(HardDrivescookie );
  	HardDrives = HardDrivescookie.getValue();
  	
  	
  	

  	Cookie cookies[];
  	cookies= req.getCookies(); //requesting client side cookies

  		//retrieve the username,e-mail of client as well as well the total cost which is equal to the motherboard+peripherals for the time being
		 for (int i=0;i<cookies.length;i++){
		 		if (cookies[i].getName().equals("username")){
					   username=(cookies[i].getValue());
		 		}
		 		else if (cookies[i].getName().equals("email")){
					    email=(cookies[i].getValue());
		 		}
				else if (cookies[i].getName().equals("TotalCost")){
		 				TotalCost=Double.parseDouble(cookies[i].getValue());
		 		}
		 }
		// calculating total cost of PC
		lala = TotalCost; 
		 for (int i=0;i<CPUa.length;i++){
		 		if (CPU.equals(CPUa[i])){
					TotalCost +=   CostCPUa[i];
					flag = true;
				}
			}
			if (flag.equals(false)){
				CPU = CPUa[0];
				TotalCost  +=  CostCPUa[0];
			}
		for (int i=0;i<RAMa.length;i++){
		 		if (RAM.equals(RAMa[i])){
					TotalCost += CostRAMa[i];
					flag = true;
				}
			}
			if (flag.equals(false)){
				RAM = RAMa[0];
				TotalCost  +=  CostRAMa[0];
			}
		for (int i=0;i<HardDrivesa.length;i++){
		 		if (HardDrives.equals(HardDrivesa[i])){
					TotalCost += CostHardDrivesa[i];
					flag = true;
				}
			}
			if (flag.equals(false)){
				HardDrives = HardDrivesa[0];
				TotalCost += CostHardDrivesa[0];
			}
			 
	// We make the Logo clickable and redirect to home page
	resp.setContentType( "text/html" ); 
	resp.getWriter().println("<script type='text/javascript'>");
  	resp.getWriter().println("function goBack()");
  	resp.getWriter().println("{");
  	resp.getWriter().println("window.history.go(-1)");
  	resp.getWriter().println("}");
  	resp.getWriter().println("</script>");
	resp.getWriter().println("<html>");
	resp.getWriter().println("<head>");
	//logo on the tab icon
	resp.getWriter().println("<title>X-Port Co.</title>");
	resp.getWriter().println("<link rel='shortcut icon' href='X-Port Icon.ico' />");
	resp.getWriter().println("</head>");
	resp.getWriter().println("<link rel='stylesheet' type='text/css' href='webstyle.css' media='screen'/>");
	resp.getWriter().println("<body>");
	//logo on the page header
	resp.getWriter().println("<div class=\"container\">");
	resp.getWriter().println("<Header>");
	resp.getWriter().println("<a <input type=\"image\" href=\"http://localhost:8080/Example02\" name=\"X-Port Logo Final\" src=\"X-Port Logo Final.png\" >");
	resp.getWriter().println("<img src='X-Port Logo Final.png'  style='width:353px;height:168px;'>");
	resp.getWriter().println("</a>");
	resp.getWriter().println("</Header>");
  



	


	//Side Bar
	resp.getWriter().println("<nav>");
	resp.getWriter().println("<b>Enroll to our Newsletter</b>");
	resp.getWriter().println("<input type=\"text\" placeholder='Enter Your E-mail' name=\"ename\"></br>");
	resp.getWriter().println("</br>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02\"><b>Home</b></a></li>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02/AboutUs.html\"><b>About X-Port</b></a></li>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02/ContactUs.html\"><b>Contact Us</b></a></li>");
	resp.getWriter().println("</nav>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    
	resp.getWriter().println("<arcticle>");
	resp.getWriter().println(" </br>");
	resp.getWriter().println(" </br>");
	resp.getWriter().println("<div align=\"Center\">");
	resp.getWriter().println("<font size=\"5\"><div><b> "+username+"</b>, &thinsp; your order is:</div></font><br>" );
	// lala == 200.0 => Desktop
	if (lala ==200.0){
			// Name and icon of type "Desktop"
		    resp.getWriter().println("<div align=\"center\" style=\" background-color:white; height:250px;\">");
		    resp.getWriter().println("<img  src='desktop.png' alt scr='Mountain View' width='240 height='140'/>");
		    resp.getWriter().println(" </a>");
		    resp.getWriter().println(" </div>");
		    resp.getWriter().println(" <div align='center' style=\" overflow:auto; align:center\">");
		    resp.getWriter().println("<b><font size=\"6\"> Desktop </font></b>");
		    resp.getWriter().println("</div>");
			resp.getWriter().println(" </br>");


	//lala == 300.0 => Laptop	
	}else if (lala == 300.0){
			//name and icon of type "Laptop"
		    resp.getWriter().println("<div align=\"center\" style=\" background-color:white; height:250px;\">");
		    resp.getWriter().println("<img  src='laptop.jpg' alt scr='Mountain View' width='240 height='140'/>");
		    resp.getWriter().println(" </a>");
		    resp.getWriter().println(" </div>");
		    resp.getWriter().println(" <div align='center' style=\" overflow:auto; align:center\">");
		    resp.getWriter().println("<b><font size=\"6\"> Laptop </font></b>");
		    resp.getWriter().println("</div>");
			resp.getWriter().println(" </br>");

	}else{
			//name and icon of type "Gaming PC"
		    resp.getWriter().println("<div align=\"center\" style=\" background-color:white; height:250px;\">");
		    resp.getWriter().println("<img  src='gamingpc.png' alt scr='Mountain View' width='240 height='140'/>");
		    resp.getWriter().println(" </a>");
		    resp.getWriter().println(" </div>");
		    resp.getWriter().println(" <div align='center' style=\" overflow:auto; align:center\">");
		    resp.getWriter().println("<b><font size=\"6\"> GamingPC </font></b>");
		    resp.getWriter().println("</div>");
			resp.getWriter().println(" </br>");
	}
	
	//Display final options and total cost of PC
	resp.getWriter().println("<div>With:</div>" );
	resp.getWriter().println("<div>CPU :"+CPU+"</div>" );
	resp.getWriter().println("<div>RAM :"+RAM+"</div>" );
	resp.getWriter().println("<div>HardDrive :"+HardDrives+"</div><br>" );
	resp.getWriter().println("<div>And it costs: <b><font size=\"5\">"+TotalCost+" 	&euro; </font><b></div><br><br>" );
	resp.getWriter().println("<div><b>Thank you for choosing X-Port!</b></div><br>" );

	 resp.getWriter().println("</article>");
		//Footer
		resp.getWriter().println("<div>");
		resp.getWriter().println("<footer>Copyright &copy; X-Port</footer>");	
		resp.getWriter().println("</div>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

}

}
