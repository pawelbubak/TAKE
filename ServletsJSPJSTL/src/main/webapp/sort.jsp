<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Buble Sort</title>
</head>
<body>
<%! private int[] data = {1, 6, 4, 5, 3}; %>

<% int size = data.length;
    boolean change1;
    do {
        change1 = false;
        int i = size - 1;
        do {
            i--;
            if (data[i + 1] < data[i]) {
                int temp = data[i];
                data[i] = data[i + 1];
                data[i + 1] = temp;
                change1 = true;
            }
        } while (i != 0);
    } while (change1); %>
Posortowane liczby:
<% for (int datum : data) { %>
<%= datum %>
<% } %>
</body>
</html>
