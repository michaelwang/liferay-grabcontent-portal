package test;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.apache.http.ParseException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;

public class MyPortlet extends MVCPortlet {

	@Override
	public void processAction(
	        ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
	        PortletPreferences prefs = actionRequest.getPreferences();
	        String url = actionRequest.getParameter("url");

	        if (url != null) {
	        	String content = "";
	        	try {
					content = Client.grabContent(url);
					JournalArticle article = JournalArticleServiceUtil.getArticle(11507l);
				    article.setContent(content);
				    
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            prefs.setValue("content", content);
	            prefs.setValue("url", url);
	            prefs.store();
	        }
	        
	        SessionMessages.add(actionRequest, "success");
	        super.processAction(actionRequest, actionResponse);
	    }
	
}
