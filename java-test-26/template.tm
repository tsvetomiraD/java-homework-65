<html>
<body>
  <span t:text="#{welcome.message}" />

 <span t:if="#{student.gender} == 'm'" t:text="Male" />
           <span t:unless="#{student.gender} == 'm'" t:text="Female" />

  <table>
    <tr t:each="student: ${students}">
      <td t:text="${student.id}" />
      <td t:text="${student.name}" />
    </tr>
  </table>
</body>
</html>