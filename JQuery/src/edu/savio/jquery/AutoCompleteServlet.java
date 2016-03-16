package edu.savio.jquery;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/AutoComplete")
public class AutoCompleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String term = request.getParameter("term");
		String[] valueBase = {"ActionScript", "AppleScript","Asp", "BASIC", "C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang", 
				"Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp", "Perl", "PHP", "Python", "Ruby","Scala", "Scheme"};
		
		ArrayList<String> values = new ArrayList<String>();
		
		if(term != null){
			for(String value : valueBase){
				if(value.startsWith(term)){
					values.add(value);
				}
				
			}
		}
		
		Gson gson = new Gson();
		String jSon = gson.toJson(values);
		
		response.getWriter().write(jSon);
		response.getWriter().flush();
		
	}

}
