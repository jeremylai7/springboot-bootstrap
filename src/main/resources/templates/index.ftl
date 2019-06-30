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
			<table data-toggle="table" data-pagination="true" data-search="true" data-url="${ctx}/index/getTableData?offset=0&limit=4">
                <thead>
                    <tr>
                        <th data-field="id">id</th>
                        <th data-field="roleId">rowid</th>
                        <th data-field="username">username</th>
                        <th data-field="password">password</th>
                        <th data-field="age">age</th>
                        <th data-field="top">top</th>
                        <th data-field="userType">userType</th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/bootstrap.js"></script>
    <script src="${ctx}/js/bootstrap-table.js"></script>
    <#--<script src="${ctx}/js/bootstrap-table-zh-CN.js"></script>-->
    <script type="text/javascript">
        function queryParams(params) {
            var query={};
            query["limit"] = params.limit;//第几条数据开始
            query["offset"] = params.offset;//数据大小
            return query;
        }
    </script>
</body>
</html>