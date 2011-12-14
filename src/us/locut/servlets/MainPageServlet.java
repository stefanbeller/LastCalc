package us.locut.servlets;

import java.net.URL;

import javax.servlet.http.HttpServlet;

import org.jsoup.nodes.*;

public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = -797244922688131805L;

	@Override
	protected void doGet(final javax.servlet.http.HttpServletRequest req,
			final javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException,
			java.io.IOException {
		final URL requestURL = new URL(req.getRequestURL().toString());

		final Document doc = Document.createShell(requestURL.toString());
		doc.head().appendElement("title").text("LastCalc");
		doc.head().appendElement("link").attr("rel", "stylesheet").attr("href", "/css/highlighting.css")
		.attr("type", "text/css");
		doc.head().appendElement("link").attr("rel", "stylesheet").attr("href", "/css/locutus.css")
		.attr("type", "text/css");
		doc.head().appendElement("script")
		.attr("src", "https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js");
		doc.head().appendElement("script").attr("src", "/js/rangy-core.js");
		doc.head().appendElement("script").attr("src", "/js/rangy-selectionsaverestore.js");
		doc.head().appendElement("script").attr("src", "/js/locutus.js");
		doc.body().appendElement("h3").text("LastCalc");
		doc.body().appendElement("h5").text("The last calculator you'll ever need");
		final Element question = doc.body().appendElement("div").attr("class", "question");
		question.appendElement("div").attr("class", "question_no").text("1");
		question.appendElement("div").attr("class", "editable").attr("contentEditable", "true");
		resp.setContentType("text/html");
		resp.getWriter().append(doc.toString());
	};

}