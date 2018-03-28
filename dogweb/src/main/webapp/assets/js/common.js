/**
 * Created by Administrator on 2017/8/30.
 */
console.log('加载初始化UI')
$(function () {
    console.log('显示模态框')
    $(document).keyup(function (event) {
        $('#b-modal-con').fadeOut();
        $('#b-modal').fadeOut();
    });
    $('#showModal').click(function () {
        $('#b-modal-con').fadeIn();
        $('#b-modal').fadeIn();
    })
    $('#b-cancel').click(function () {
        $('#b-modal-con').fadeOut();
        $('#b-modal').fadeOut();

    })
})

$(function () {
    console.log('初始化按钮下拉')
    $('#menubtn').mouseover(function () {
        // $('#menu').css('display', 'block');
        $("#menu").slideToggle();
    })
    $('#menubtn').mouseout(function () {
        // $("#menu").fadeOut(300);
        $('#menu').css('display', 'none');
    })
    $('#menu').mouseover(function () {
        $('#menu').css('display', 'block');
    })
    $('#menu').mouseout(function () {
        $('#menu').css('display', 'none');
    })

    // $('#b-modal-con').css('display','none')

})
$(function () {
    console.log('手风琴下拉菜单')
    var Accordion = function (el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;
        var links = this.el.find('.link');
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    }

    Accordion.prototype.dropdown = function (e) {
        var $el = e.data.el;
        $this = $(this),
            $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
        }
        ;
    }

    var accordion = new Accordion($('#accordion'), false);
});
$(function () {
    console.log('轮播');
    $("#div-skippr").skippr({
        transition: 'slide',
        speed: 1000,
        easing: 'easeOutQuart',
        navType: 'block',
        childrenElementType: 'div',
        arrows: true,
        autoPlay: true,
        autoPlayDuration: 3000,
        keyboardOnAlways: false,
        hidePrevious: false
    });
    // $("#skippr").skippr();
});

