<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.PortletPreferences" %>

<portlet:defineObjects />

<liferay-ui:success key="success" message="Greeting saved successfully!"/>

<%
PortletPreferences prefs = renderRequest.getPreferences();
String content = (String)prefs.getValue(
"content", "Hello! Welcome to our portal.");
%>

<p><%= content %></p>

<portlet:renderURL var="editGreetingURL">
    <portlet:param name="mvcPath" value="/edit.jsp" />
</portlet:renderURL>

<p><a href="<%= editGreetingURL %>">Edit greeting</a></p>