<%@page import="java.io.IOException"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page errorPage="/error.jsp"%>

<html>
    <head>
        <title>Калькулятор</title>
    </head>
    <body>
        <%
            // Retrieve the first operand
            String sNum1 = request.getParameter("num1");

            // Retrieve the second operand 
            String sNum2 = request.getParameter("num2");

            // Retrieve the Operator 
            String sOperator = request.getParameter("button");

            String sRes = "0";

            int result = 0;
            int num1 = 0;
            int num2 = 0;

            if (sNum1 != null && sNum2 != null && sOperator != null) {
                num1 = Integer.parseInt(sNum1);
                num2 = Integer.parseInt(sNum2);

                if (sOperator.equals("sum")) {
                    result = num1 + num2;
                    sRes = num1 + " + " + num2 + " = " + result;
                } else if (sOperator.equals("minus")) {
                    result = num1 - num2;
                    sRes = num1 + " + " + num2 + " = " + result;
                } else if (sOperator.equals("mult")) {
                    result = num1 * num2;
                    sRes = num1 + " + " + num2 + " = " + result;
                } else if (sOperator.equals("div")) {
                    if (num2 == 0) {
                        throw new Exception("Деление на 0!");
                    } else {
                        result = num1 / num2;
                        sRes = num1 + " / " + num2 + " = " + result;
                    }
                } else {
                    throw new Exception("Что-то пошло не так!");

                }
            }

        %>

        <form name="frmCal" action="index.jsp">
            Первое число: <input type="text" name="num1" size="4" value="<%=num1%>"> <br>
            Второе число: <input type="text" name="num2" size="4" value="<%=num2%>"> <br>
            <button type="submit" name="button" value="sum">+</button>
            <button type="submit" name="button" value="minus">-</button>
            <button type="submit" name="button" value="mult">*</button>
            <button type="submit" name="button" value="div">/</button>
            <br>            
        </form>
        <hr>
        Результат: <%= sRes%>
    </body>

</html>


