$(document).ready(function() {
    // 手机导航
    $('.menuBtn').append('<b></b><b></b><b></b>');
    $('.menuBtn').click(function(event) {
        $(this).toggleClass('open');
        var _winw = $(window).width();
        var _winh = $(window).height();
        if ($(this).hasClass('open')) {
            $('body').addClass('open');
            if (_winw <= 1200) {
                $('.hdr').stop().slideDown();
            }
        } else {
            $('body').removeClass('open');
            if (_winw <= 1200) {
                $('.hdr').stop().slideUp();
            }
        }
    });
    $(window).on('resize', function(e) {
        if ($(window).width() > 1200) {
            $('.menuBtn').removeClass('open');
            $('.hdr').css('display', '');
        }
    });
    // 导航
    if ($(".nav li").find('dl').length) {
        $(".nav li").find("dl").siblings("a").attr("href", "javascript:;")
    };

    function myNav() {
        var _winw = $(window).width();
        if (_winw >= 1200) {
            $('.nav li').bind('mouseenter', function() {
                $(this).find('dl').stop().slideDown("fast");
                if ($(this).find('dl').length) {
                    $(this).addClass('ok');
                }
            });
            $('.nav li').bind('mouseleave', function() {
                $(this).removeClass('ok');
                $(this).find('dl').stop().slideUp("fast");
            });
            $('body,.menuBtn').removeClass('open');
        } else {
            $('.nav .v1').click(function() {
                $(this).parents(".nav").find("dl").stop().slideUp("fast");
                if ($(this).siblings('dl').length) {
                    $(this).siblings('dl').stop().slideToggle("fast");
                    return false;
                }
            });
        }
    }
    myNav();
    $(window).resize(function(event) {
        myNav();
        $('.menuBtn').removeClass('open');
    });

    // 搜索
    $(".sobox .tit").click(function() {
        $(this).siblings('.so').slideToggle('fast');
    })

    //展开收起
    $(".cuttle dl dt").click(function() {
        $(this).parents('.cuttle').find("dd").stop().slideUp("fast");
        $(this).siblings('dd').stop().slideToggle();
        $(this).toggleClass('ok');
        if ($(this).hasClass('ok')) {
            $(this).parents('.cuttle').find('dt').removeClass('ok');
            $(this).addClass('ok');
        } else {
            $(this).removeClass('ok');
        };
    });

    // 选项卡 鼠标点击
    $(".TAB_CLICK li").click(function() {
        var tab = $(this).parent(".TAB_CLICK");
        var con = tab.attr("id");
        var on = tab.find("li").index(this);
        $(this).addClass('on').siblings(tab.find("li")).removeClass('on');
        $(con).eq(on).show().siblings(con).hide();
    });

    // 滚动导航悬浮
    $(document).on('scroll', function() {
        var scrollH = $(this).scrollTop();
        if (scrollH > $('.header').height()) {
            $('.header').addClass('fixed');
        } else {
            $('.header').removeClass('fixed');
        }
    })
});