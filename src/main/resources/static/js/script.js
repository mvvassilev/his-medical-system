//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;
});

layui.use('element', function(){
  var element = layui.element;
  
  //一些事件监听
  element.on('tab(demo)', function(data){
    console.log(data);
  });
});