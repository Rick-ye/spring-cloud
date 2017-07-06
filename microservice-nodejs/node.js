var http = require('http');
var url = require('url');
var path = require('path');

var server = http.createServer(function (request, response) {
	//获得一个请求的路径
	var pathname = url.parse(request.url).pathname;
	response.writeHead(200, {'Content-Type' : 'application/json; charset=utf-8'});
	//访问http://localhost:8060/,将会返回{"index" : "欢迎来到首页"}
	//访问http://localhost:8060/health,将会返回{ "status" : "UP"}
	if(pathname == '/'){
		response.end(JSON.stringify({"index" : "欢迎来到首页"}));
	} else if(pathname == '/health.json') {
		response.end(JSON.stringify({ "status" : "UP"}))
	} else {
		response.end("404");
	}

	// 发送 HTTP 头部 
	// HTTP 状态值: 200 : OK
	// 内容类型: text/plain
	//response.writeHead(200, {'Content-Type': 'text/plain'});

	// 发送响应数据 "Hello World"
	//response.end('Hello World\n');
});

server.listen(8060, function() {
	console.log('listening on localhost:8060');
})
// 终端打印如下信息
//console.log('Server running at http://127.0.0.1:8888/');