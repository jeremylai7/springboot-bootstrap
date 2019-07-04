<!DOCTYPE html>
<#assign ctx=request.contextPath>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link href="${ctx}/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-table.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row">
			<table data-toggle="table"  data-side-pagination="server" data-search="true"
                   data-pagination="true" data-query-params="queryParams"  data-pagination-loop="false"
                   data-url="${ctx}/index/getTableData">
                <thead>
                    <tr>
                        <th data-field="id" data-align="center" 	data-sortable="true">id</th>
                        <th data-field="roleId" data-align="center">rowid</th>
                        <th data-field="username" data-align="center" data-sortable="true">username</th>
                        <th data-field="password" data-align="center">password</th>
                        <th data-field="age" data-align="center">age</th>
                        <th data-field="top" data-align="center">top</th>
                        <th data-field="userType" data-align="center">userType</th>
                    </tr>
                </thead>
            </table>
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
    </script>
</body>
</html>