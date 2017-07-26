<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>${mname}</title>
    <%@ include file="../../include/top_list.jsp" %>
    <%@ include file="../../include/top_Jcrop.jsp" %>
    <%@ include file="../../include/top_lightbox.jsp" %>
    <%@ include file="../../include/top_kindeditor.jsp" %>
    <script src="<%=uiPath%>lib/jquery-ui/jquery-ui.js" type="text/javascript"></script>
    <script src="<%=uiPath%>lib/jquery-ui/jquery-ui-slide.min.js" type="text/javascript"></script>
    <script src="<%=uiPath%>lib/jquery-ui/jquery-ui-timepicker-addon.js" type="text/javascript"></script>

    <style type="text/css">
        .subject_img {
            max-width: 400px;
        }
    </style>


    <script type="text/javascript">
        var Validator = null;
        var isSubmiting = false;
        var op = "${op}";

        //文件上传
        var fileType = null;//文件上传的标识

        var subjectContentEditor = null;
        $(function () {

            KindEditor.ready(function (K) {
                subjectContentEditor = K.create("#subjectContent", {
                    uploadJson: '<%=basePath%>kindeditor/uploadJson.htm',
                    afterBlur: function () {
                        this.sync();
                    }
                });
            });


            $("#toptoolbar").ligerToolBar({
                items: [{line: true}, {
                    text: '保存',
                    click: h2y_save,
                    icon: 'save'
                }, {line: true}, {text: '刷新', click: h2y_refresh, icon: 'refresh'}]
            });

            //验证信息
            ${validationRules};
            //验证属性设置
            $.metadata.setType("attr", "validate");
            Validator = deafultValidate($("#editform"));

            $("#ord").ligerSpinner({type: 'int', height: 25, width: 194, value:${subject.ord}});

            var _mobileImgData = '${mobileImgData}';
            if (_mobileImgData != null && _mobileImgData != "null" && _mobileImgData != "") {
                var mobileImgData = eval("(" + _mobileImgData + ")");
                $("#mobileImgData").val(JSON.stringify(mobileImgData));
                $("#h2y_file_div_mobile").html("<img class=\"subject_img\" src=\"" + mobileImgData.url + "\">");
            }

            var _androidImgData = '${androidImgData}';
            if (_androidImgData != null && _androidImgData != "null" && _androidImgData != "") {
                var androidImgData = eval("(" + _androidImgData + ")");
                $("#androidImgData").val(JSON.stringify(androidImgData));
                $("#h2y_file_div_android").html("<img class=\"subject_img\" src=\"" + androidImgData.url + "\">");
            }

            var _iosImgData = '${iosImgData}';
            if (_iosImgData != null && _iosImgData != "null" && _iosImgData != "") {
                var iosImgData = eval("(" + _iosImgData + ")");
                $("#iosImgData").val(JSON.stringify(iosImgData));
                $("#h2y_file_div_ios").html("<img class=\"subject_img\" src=\"" + iosImgData.url + "\">");
            }

            var _pcImgData = '${pcImgData}';
            if (_pcImgData != null && _pcImgData != "null" && _pcImgData != "") {
                var pcImgData = eval("(" + _pcImgData + ")");
                $("#pcImgData").val(JSON.stringify(pcImgData));
                $("#h2y_file_div_pc").html("<img class=\"subject_img\" src=\"" + pcImgData.url + "\">");
            }
        });


        function h2y_save() {

            if (!Validator.form()) return;

            var queryString = $('#editform').serialize();
            if (isSubmiting) {
                alert("表单正在提交，请稍后操作！");
                return;
            }

            if ($("#subjectName").val() == "") {
                alert("主题名称不能为空!");
                return;
            }


            if ($("#mobileImgData").val() == "") {
                alert("请上传图片!");
                return;
            }
            isSubmiting = true;

            //同步富文本编辑框数据
            subjectContentEditor.sync();
            $.post("recruit/subject/save.htm", queryString, function (data) {

                var jsonReturn = eval("(" + data + ")");
                if (op == "modify") {
                    if (jsonReturn.code == "1") {

                        alert(jsonReturn.msg);
                        //管理页面列表刷新
                        top.f_getframe("recruit_subject_init_htm").f_query();

                        top.f_delTab("recruit_subject_add_htm_id_${subject.id}");
                    } else {
                        alert(jsonReturn.msg);
                    }
                } else {
                    if (jsonReturn.code == "1") {
                        alert(jsonReturn.msg);
                        top.f_getframe("recruit_subject_init_htm").f_query();
                        top.f_delTab("recruit_subject_add_htm_type_${subject.type}");
                    } else {
                        alert(jsonReturn.msg);
                    }
                }
                isSubmiting = false;
            });
        }

        /**
         * 获取
         */
        function selectSubjectType() {
            var subjectType = $("input[type=radio][name='subjectType']:checked").val();
        }

        function h2y_refresh() {
            document.location.reload();
        }

        /**
         * 文件上传初始化
         */
        function h2y_fileupload(type) {

            var fileTypeExts = "*.jpg;*.png;*.jpeg;*.gif";

            openFileUploadDialog({
                fileTypeExts: fileTypeExts,
                multi: true,
                fileSizeLimit: 200,
                uploadLimit: 1
            });
            fileType = type;
        }


        function h2y_fileUploadCallBack(data) {

            if (data == null) return;

            $(data).each(function () {
                //添加属性
                this['fileType'] = fileType;
                var fileData = JSON.stringify(this);
                $("#" + fileType + "ImgData").val(fileData);

                var tempurl = this.url;
                var pattern = "/save_path";
                tempurl = tempurl.replace(new RegExp(pattern), "");

                $("#h2y_file_div_" + fileType).html("<img class=\"subject_img\" src=\"" + tempurl + "\">");
            });
        }

    </script>

    <style type="text/css">
        body {
            font-size: 12px;
        }
    </style>

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
    <div>
        <input type="hidden" name="id" value="${subject.id}"/>
        <input type="hidden" name="instId" value="${subject.instId}"/>
        <input type="hidden" name="instCode" value="${subject.instCode}"/>
        <input type="hidden" name="unitId" value="${subject.unitId}"/>
        <input type="hidden" name="unitCode" value="${subject.unitCode}"/>
        <input type="hidden" name="type" value="${subject.type}"/>
        <input type="hidden" id="mobileImgData" name="mobileImgData" value="${mobileImgData}"/>
        <input type="hidden" id="weixinImgData" name="weixinImgData" value="${weixinImgData}"/>
        <input type="hidden" id="androidImgData" name="androidImgData" value="${androidImgData}"/>
        <input type="hidden" id="iosImgData" name="iosImgData" value="${iosImgData}"/>
        <input type="hidden" id="pcImgData" name="pcImgData" value="${pcImgData}"/>
    </div>
    <table class="h2y_table">

        <tr>
            <td class="h2y_table_label_td">名称:</td>
            <td class="h2y_table_edit_td2">
                <input name="subjectName" type="text" id="subjectName" class="h2y_input_long"
                       value="${subject.subjectName}"/>
            </td>
        </tr>

        <tr>
            <td class="h2y_table_label_td">类型:</td>
            <td class="h2y_table_edit_td2">
                <h2y:input name="subjectType" id="subjectType" type="radio"
                           initoption="1,商品列表"
                           value="${subject.subjectType}" onclick="selectSubjectType()"/>
                <%--<h2y:input name="subjectType" id="subjectType" type="radio"--%>
                <%--initoption="1,商品列表:2,商品详情:3,url页面:4,宣传页面"--%>
                <%--value="${subject.subjectType}" onclick="selectSubjectType()"/>--%>
            </td>
        </tr>
        <tr id="subjectUrl_tr" style="display: none;">
            <td class="h2y_table_label_td">URL:</td>
            <td class="h2y_table_edit_td2">
                <input name="subjectUrl" type="text" id="subjectUrl" class="h2y_input_long"
                       value="${subject.subjectUrl}"/>
            </td>
        </tr>

        <tr>
            <td class="h2y_table_label_td">排序:</td>
            <td class="h2y_table_edit_td2">
                <input name="ord" type="text" id="ord" class="h2y_input_long"
                       value="${subject.ord}"/>
            </td>
        </tr>

        <tr style="display: none;">
            <td class="h2y_table_label_td">内容:</td>
            <td class="h2y_table_edit_td2" colspan="3">
                <textarea name="subjectContent" id="subjectContent"
                          class="h2y_editor_textarea">${subject.subjectContent}</textarea>
            </td>
        </tr>

        <tr>
            <td class="h2y_table_label_td">
                <input type="button" value="Mobile图片" class="button"
                       onclick="h2y_fileupload('mobile')"/>:
            </td>
            <td class="h2y_table_edit_td2">
                <div id="h2y_file_div_mobile"></div>
            </td>
        </tr>
        <tr style="display: none;">
            <td class="h2y_table_label_td">
                <input type="button" value="Android图片" class="button"
                       onclick="h2y_fileupload('android')"/>:
            </td>
            <td class="h2y_table_edit_td2">
                <div id="h2y_file_div_android"></div>
            </td>
        </tr>

        <tr style="display: none;">
            <td class="h2y_table_label_td">
                <input type="button" value="IOS图片" class="button"
                       onclick="h2y_fileupload('ios')"/>:
            </td>
            <td class="h2y_table_edit_td2">
                <div id="h2y_file_div_ios"></div>
            </td>
        </tr>

        <tr style="display: none;">
            <td class="h2y_table_label_td">
                <input type="button" value="PC图片" class="button"
                       onclick="h2y_fileupload('pc')"/>:
            </td>
            <td class="h2y_table_edit_td2">
                <div id="h2y_file_div_pc"></div>
            </td>
        </tr>
    </table>
</form>
</body>
</html>