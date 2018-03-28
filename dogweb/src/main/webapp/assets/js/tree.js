/**
 * Created by Administrator on 2017/7/17.
 */
function show_tree() {
    var id = 10000;
    //id编号和名词固定
    var zNodes = [
        {
            id: 0,
            pId: 1,
            name: "操作樹",
            isParent: true,
            open: true,
            title: "双击开打列表"
        },
        {id: 10, pId: 0, name: "初始化", isParent: true, open: true},
        {id: 20, pId: 0, name: "同步數據", isParent: true, open: true},
        {id: 30, pId: 0, name: "統計", isParent: true, open: true},
        {id: 40, pId: 0, name: "云服務器", isParent: true, open: true},
        {id: 50, pId: 40, name: "阿里", isParent: true, open: true},
        {id: 60, pId: 40, name: "騰訊", isParent: true, open: true},
        {id: 70, pId: 40, name: "青雲", isParent: true, open: true}
    ];
    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: tree_callback
        }
    };
    $.fn.zTree.init($("#operation_tree"), setting, zNodes);
}
function tree_callback(event, tree, treeNode) {
    console.info(event);
    console.info(tree);
    console.info(treeNode);
    if (treeNode.id == 20) {
    }
    if (treeNode.id == 40) {
    }
}

$(function () {
    show_tree();
})