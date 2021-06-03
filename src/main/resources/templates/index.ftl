<!DOCTYPE html>
<#assign ctx=request.contextPath>
<html>
<head>
    <meta charset="utf-8">
    <title>用户后台管理系统</title>
    <link href="${ctx}/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-table.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row">
			<table id="table" data-toggle="table"  data-side-pagination="server" data-search="true"
                   data-pagination="true" data-query-params="queryParams"  data-pagination-loop="false"
                   data-click-to-select="true" data-url="${ctx}/index/getTableData">
                <thead>
                    <tr>
                        <th data-checkbox="true"></th>
                        <th data-field="id" data-align="center" data-sortable="true">编号</th>
                        <th data-field="roleId" data-align="center">角色id</th>
                        <th data-field="username" data-align="center" data-sortable="true">用户名</th>
                        <th data-field="age" data-align="center">年龄</th>
                        <th data-field="top" data-align="center">是否为超级管理员</th>
                        <th data-field="userType" data-align="center">用户类型</th>
                    </tr>
                </thead>
            </table>
        </div>
        <div id="selectOne" class="row alert alert-warning hide">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>
            <strong>警告！</strong>请至少选中一条数据。
        </div>
        <div class="row">
            <button type="button" id="add" data-target="#myModal" data-toggle="modal" class="btn btn-primary pull-right" style="margin-left: 10px">新增</button>
            <button type="button" id="confirmDelete" class="btn btn-danger pull-right">删除</button>
        </div>

    </div>
    <!-- 弹出框 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="form">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="username" id="Username" placeholder="Username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" name="password" class="form-control" id="psd" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputAge" class="col-sm-2 control-label">Age</label>
                            <div class="col-sm-10">
                                <input type="number" name="age" class="form-control" id="age" placeholder="Age">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="btn-submit" class="btn btn-primary">提交</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 删除确认 -->
    <div class="modal fade" id="delcfmModel">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title">提示信息</h4>
                </div>
                <div class="modal-body">
                    <p>您确认要删除吗？</p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="url"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a id="del" class="btn btn-success" data-dismiss="modal">确定</a>
                </div>
            </div>
        </div>
    </div>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/bootstrap.js"></script>
    <script src="${ctx}/js/bootstrap-table.js"></script>
    <script src="${ctx}/js/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript">
        function queryParams(params) {
            var query={};
            query["limit"] = params.limit;//第几条数据开始
            query["offset"] = params.offset;//数据大小
            query["search"] = params.search;//搜索
            query["sort"] = params.sort;//搜索字段
            query["order"] = params.order;//排序
            return query;
        }

        $("#add").click(function () {
            $("#myModalLabel").text("新增");
        })

        //提交
        $("#btn-submit").click(function () {
            $.post("${ctx}/index/add",$('#form').serializeArray(),function (result) {
                $('#myModal').modal('hide');
                location.reload();
            })

        })
        //确认删除
        $("#confirmDelete").click(function () {
            var select = $("#table").bootstrapTable('getSelections');
            if (select.length == 0) {
                $("#selectOne").removeClass("hide");
            } else {
                $("#selectOne").addClass("hide");
                $('#delcfmModel').modal('show');
            }
        })

        //批量删除
        $("#del").click(function () {
            var select = $("#table").bootstrapTable('getSelections');
            var ids = "";
            for(var i = 0;i < select.length;i++){
                ids +=","+select[i].id;
            }
            ids = ids.substr(1);
            if(ids != ""){
                $.post("${ctx}/index/delete",{ids:ids},function (result) {
                    location.reload();
                })
            }
        })

    </script>
</body>
</html>