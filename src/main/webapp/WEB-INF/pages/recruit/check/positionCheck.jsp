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
                    if (top.f_getframe("_recruit_check_positionCheck_htm_id_${position.id}") != null) {
                        top.f_getframe("recruit_check_positionInit_htm").f_query();
                        top.f_delTab("_recruit_check_positionCheck_htm_id_${position.id}");
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
    <input type="hidden" name="id" value="${position.id}" name="id">
    <input type="hidden" name="type" value="2" name="type">
    <table class="h2y_table">
        <tr>
            <td class="h2y_table_label_td">企业名称：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${company.companyName}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">职位名称：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${position.jobName}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">工作性质：</td>
            <td class="h2y_table_edit_td2" >
                <c:if test="${position.jobType==1}">
                    全职
                </c:if>
                <c:if test="${position.jobType==2}">
                    兼职
                </c:if>
            </td>
            <td class="h2y_table_label_td">招聘人数：</td>
            <td class="h2y_table_edit_td">
                ${position.recruitingNum}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">学历：</td>
            <td class="h2y_table_edit_td2" >
                <c:if test="${position.qualification==1}">
                    高中
                </c:if>
                <c:if test="${position.qualification==2}">
                    大专
                </c:if>
                <c:if test="${position.qualification==3}">
                    本科
                </c:if>
                <c:if test="${position.qualification==4}">
                    硕士
                </c:if>
                <c:if test="${position.qualification==5}">
                    博士
                </c:if>
            </td>
            <td class="h2y_table_label_td">工作经验：</td>
            <td class="h2y_table_edit_td">
                ${position.experience}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">薪资：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${position.salaryMin}-${position.salaryMax}k
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">
                职位介绍：
            </td>
            <td class="h2y_table_edit_td2" colspan="3">
                <textarea id="introduction" class="h2y_editor_textarea">${position.jobDescription}</textarea>
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">
                福利待遇：
            </td>
            <td class="h2y_table_edit_td2" colspan="3">
                <textarea id="welfareTreatment" class="h2y_editor_textarea">${position.welfareTreatment}</textarea>
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">职位标签：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${positionLabelName}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">技能要求：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${position.skillsRequirement}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">工作地址：</td>
            <td class="h2y_table_edit_td2" colspan="3">
                ${position.zoneName}${position.address}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">职位失效日期：</td>
            <td class="h2y_table_edit_td" >
                <fmt:formatDate value="${position.expiryDate}" pattern="yyyy-MM-dd"/>
            </td>
            <td class="h2y_table_label_td">联系人：</td>
            <td class="h2y_table_edit_td">
                ${position.contacts}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">简历接收邮箱：</td>
            <td class="h2y_table_edit_td" >
                ${position.receiveMailbox}
            </td>
            <td class="h2y_table_label_td">电话：</td>
            <td class="h2y_table_edit_td">
                ${position.telephone}
            </td>
        </tr>
        <tr>
            <td class="h2y_table_label_td">创建时间：</td>
            <td class="h2y_table_edit_td" colspan="3">
                <fmt:formatDate value="${position.createDate}" pattern="yyyy-MM-dd HH:mm" />
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
