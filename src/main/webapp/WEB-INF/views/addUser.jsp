<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>
<html>
  <head>
    <title>${message}</title>
  </head>
  <body>
    <h1>${message}</h1>
    <f:form method="POST" action="addUser" commandName="user">
    <table>
      <tbody>
        <tr>
          <td>User name:</td>
          <td><f:input path="username" size="10" maxlength="10"></f:input><f:errors path="username" cssClass="error"></f:errors></td>
        </tr>
        <tr>
          <td>email:</td>
          <td><f:input path="email" size="30"></f:input><f:errors path="email" cssClass="error"></f:errors></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><f:input path="password" size="6"></f:input><f:errors path="password" cssClass="error"></f:errors></td>
        </tr>
        <tr>
          <td>Country:</td>
          <td><f:input path="country" size="20"></f:input><f:errors path="country" cssClass="error"></f:errors></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Add User"></td>
        </tr>
      </tbody>
    </table>
    </f:form>
  </body>
</html>