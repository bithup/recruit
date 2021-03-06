<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>${mname}</title>
    <%@ include file="../../include/top_list.jsp" %>
    <script type="text/javascript">

        var id = 0;
        $(function () {
            $("#toptoolbar").ligerToolBar({items: [${toolbar}]});
            $("#layout1").ligerLayout({
                leftWidth: 230,
                height: "100%",
                topHeight: 23,
                allowTopResize: false
            });
            getList()
        });

        function getList(){
            var jobName = $("#jobName").val();
            var url_1 = "/recruit/position/getListPage.htm?isCheck=0&jobName="+jobName;
            $("#listgrid").ligerGrid({
                columns: [${gridComluns}],
                url: url_1,
                parms: [
                    {name: "pid", value: id}, {name: "op", value: "grid"}
                ],
                showTitle: false,
                dataAction: "server",
                sortName: "ord",
                pageSize: 20,
                height: "100%",
                width: "100%",
                usePager: true,
                pageSizeOptions: [20, 30, 50, 100],
                onSelectRow: function (row, index, data) {
                    //id = row.id;
                },
                onDblClickRow: function (row, index, data) {
                    //alert("行双击事件");
                }
            });


        }

        function h2y_search(){
            getList();
        }

        function h2y_check(){
            var manager = $("#listgrid").ligerGetGridManager();
            var rows = manager.getCheckedRows();
            if (rows == null || rows.length == 0) {
                alert('请选择职位');
                return;
            } else if (rows.length > 1) {
                alert("请选择单行记录");
                return;
            }
            var src = "/recruit/check/positionCheck.htm?id=" + rows[0].id;
            top.f_addTab("_recruit_check_positionCheck_htm_id_" + rows[0].id, "职位审核详情", src);
        }

        function h2y_refresh(){
            window.location.reload();
        }

        function f_query() {
            var manager = $("#listgrid").ligerGetGridManager();
            manager.setOptions({
                parms: [
                    {name: "pid", value: id}, {name: "op", value: "grid"}
                ]
            });
            manager.loadData(true);
        }
    </script>
</head>
<body>
<div id="layout1" style="width: 100%">
    <input type="hidden " id="status" name="status" value=""/>
    <div position="top">
        <table width="100%" class="my_toptoolbar_td">
            <tr>
                <td id="my_toptoolbar_td">
                    <div class="l-toolbar">&nbsp;${mname}</div>
                </td>
                <td align="right" width="50%">
                    <div id="toptoolbar"></div>
                </td>
            </tr>
        </table>
    </div>
    <div position="center" title="">

        <div id="conditiondiv" style="align:center;padding-top:5px;padding-bottom:5px;">
            职位名称:<input type="text " name="jobName" id="jobName"/>
            </select>
            <%--开始时间：<input type="text " name="startTime" id="startTime" pattern="yyyy-MM-dd HH:mm:ss">
           结束时间：<input type="text " name="endTime" id="endTime" pattern="yyyy-MM-dd HH:mm:ss">
          开始时间:
             <input name="spreadStartDate" type="text" id="shop_spreadStartDate"  class="h2y_input_just"
                    value="<fmt:formatDate value="${nowdate}"  pattern="yyyy-MM-dd HH:mm"/>" />
             <input id="text" type="button" onclick="text()"/>--%>
        </div>

        <div id="listgrid"></div>
    </div>
</div>
</body>
</html>
