package Task3;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;
import java.util.List;

public class SVATag2 extends TagSupport {
	DBCommands dbcommands;
	@Override
	public int doStartTag() throws JspException {
		String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://GOKING;databaseName=LAB9_10_TPvI;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
		String username = "sa";
		String password = "1111";
		Database db = new Database(driver,url,username,password);
		this.dbcommands = new DBCommands(db);
		List<User> users = dbcommands.GetList();
		String header = "<table width=\"100%\" border=\"1\" cellpadding=\"4\" cellspacing=\"0\">\n" +
				"   <caption>Таблица пользователей</caption>\n" +
				"   <tr>\n" +
				"    <th>&nbsp;</th><th>Login</th><th>Password</th><th>Role</th>\n" +
				"   </tr>";
		String row;
		try {
			JspWriter out = pageContext.getOut();
			out.write(header);
			for (int i = 0;i<users.size();i++){
				row = "   <tr>\n" +
						"    <td>user "+(i+1)+"</td><td>"+users.get(i).Login+"</td><td>"+users.get(i).Password+"</td><td>"+users.get(i).Role+"</td>\n" +
						"   </tr>";
				out.write(row);
				row	= "";
			}
			
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
