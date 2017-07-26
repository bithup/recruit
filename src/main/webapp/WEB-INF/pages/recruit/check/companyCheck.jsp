<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>${mname}</title>
    <%@ include file="../../include/top_list.jsp" %>
    <style type="text/css">
        .goods_pic {
            max-width: 400px;
            max-height: 300px;
        }
    </style>

    <script type="text/javascript">
        var isSubmiting = false;
        $(function () {
            $("#toptoolbar").ligerToolBar({
                items: [
                    {line: true},
                    {text: '保存', click: h2y_save, icon: 'save'},
                    {line: true},
                    {text: '刷新', click: h2y_refresh, icon: 'refresh'}
                ]
            });
        });

        function h2y_save(){
            var queryString = $('#editform').serialize();
            var isCheck = $("#isCheck option:selected").val();
            if(isCheck==null||isCheck==''){
                alert(isCheck);
                alert("请选择审核结果！");
                return;
            }
            if (isSubmiting) {
                alert("表单正在提交，请稍后操作！");
                return;
            }
            isSubmiting = true;
            $.post("/recruit/check/save.htm", queryString, function (data) {
                var jsonReturn = eval("(" + data + ")");
                if (jsonReturn.code==1) {
                    alert(jsonReturn.msg);
                    if (top.f_getframe("_recruit_check_companyCheck_htm_id_${companyInfo.id}") != null) {
                        top.f_getframe("recruit_check_companyInit_htm").f_query();
                        top.f_delTab("_recruit_check_companyCheck_htm_id_${companyInfo.id}");
                    }
                } else {
                    alert(jsonReturn.msg);
                }
                isSubmiting = false;
            });
        }
        function h2y_refresh(){
            document.location.reload();
        }
    </script>
</head>
<body>
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
<form name="editform" method="post" action="" id="editform">
    <input type="hidden" name="id" value="${companyInfo.id}" name="id">
    <input type="hidden" name="type" value="1" name="type">
    <table class="h2y_table">
        <tr>
            <td class="h2y_table_label_td">企业名称：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${companyInfo.companyName}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">企业简称：</td>
            <td class="h2y_table_edit_td2" >
                ${companyInfo.shortName}
            </td>
            <td class="h2y_table_label_td">行业：</td>
            <td class="h2y_table_edit_td">
                ${companyInfo.industryName}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">企业性质：</td>
            <td class="h2y_table_edit_td2" >
                ${companyInfo.companyType}
            </td>
            <td class="h2y_table_label_td">企业规模：</td>
            <td class="h2y_table_edit_td">
                ${companySize}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">所在区域：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${companyInfo.zoneName}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">详细地址：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${companyInfo.address}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">
                企业简介：
            </td>
            <td class="h2y_table_edit_td2" colspan="3">
                <textarea id="introduction" class="h2y_editor_textarea">${companyInfo.intro}</textarea>
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">邮箱：</td>
            <td class="h2y_table_edit_td" >
                ${companyInfo.email}
            </td>
            <td class="h2y_table_label_td">电话：</td>
            <td class="h2y_table_edit_td">
                ${companyInfo.mobile}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">电话（座机）：</td>
            <td class="h2y_table_edit_td" >
                ${companyInfo.telephone}
            </td>
            <td class="h2y_table_label_td">联系人：</td>
            <td class="h2y_table_edit_td">
                ${companyInfo.contacts}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">企业官网地址：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${companyInfo.companyUrl}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">企业logo：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                <img src="${companyInfo.logoRealPath}">
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">企业三证：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                <img src="${companyInfo.credentialsRealPath}">
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">认证状态：</td>
            <td class="h2y_table_edit_td" >
               ${companyInfo.isCertify}
            </td>
            <td class="h2y_table_label_td">创建时间：</td>
            <td class="h2y_table_edit_td" >
                <fmt:formatDate value="${companyInfo.createDate}" pattern="yyyy-MM-dd HH:mm"/>
            </td>
        </tr>

        <tr>
            <td class="h2y_table_label_td">
                审核结果：
            </td>
            <td class="h2y_table_edit_td2" colspan="3">
                <select name="isCheck" id="isCheck">
                    <option value="1">通过</option>
                    <option value="2">不通过</option>
                </select></br>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
