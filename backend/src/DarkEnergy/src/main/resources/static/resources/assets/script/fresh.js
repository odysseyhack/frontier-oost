 $(document).keyup(function (e) {
     if (e.keyCode == 27) {
         $("body").click();
     }
 });

 $(window).scroll(function () {
     calcContentHeight();
 });

 // Header and footer
 var calcContentHeight = function () {
     var top = window.pageYOffset;
     var skeletonFooterHeight = $('.skeleton--footer').height();

     if (top == 0) {
         $('.skeleton--header').removeClass('fixed');
     } else {
         $('.skeleton--header').addClass('fixed');
     }
     $('.skeleton--content').css('padding-bottom', skeletonFooterHeight);
 };

 $('.sidebar--container').mCustomScrollbar({
     scrollInertia: 200
 });

 $('select').select2();

 jQuery(document).ready(function () {
     //Fold-out appmenu for extra information
     $(".sidebar-appmenu").click(function () {
         $(".sidebar-appmenu-apps").fadeToggle("fast");
         $(".sidebar-appmenu").toggleClass("sidebar-appmenu--active");
     });
     //Fold-out header for extra information
     $(".header--information-primary").click(function () {
         $(".header--information-secondary").slideToggle(function () {
             $(".header--information-primary").toggleClass("active");
             calcContentHeight();
         });
     });
     //Set height to show content behind fixed header and appmenu
     var headerHeight = $(".header ul").outerHeight();
     $(".sidebar-appmenu").css("height", headerHeight);
     $(".sidebar-appmenu-fold").css("padding-top", headerHeight);

     $('body')
         .append('<div class="mask"></div>')
         .keydown(function (e) {
             if (e.keyCode == 27) {
                 modalHide();
             };
         });
     $('.modal-show')
         .click(function () {
             var modalId = $(this).attr('name');
             modalShow(modalId);
         });
     $('.modal-hide')
         .click(function () {
             modalHide();
         });

 });

 function modalShow(modalId) {
     $('.mask').fadeIn(100);
     $('#' + modalId).fadeIn(200);
     $('body').css('overflow', 'hidden');
 }

 function modalHide(modalId) {
     $('.mask').fadeOut(100);
     $('.modal').fadeOut(200);
     $('body').css('overflow', 'auto');
 }

 var showSubLevels = function (item) {
     var target = $(item).parent('.row-wrapper');
     if ($(target).hasClass('closed')) {
         $(target).removeClass('closed');
         $(target).addClass('open');

         $(target).children('.row-wrapper').slideDown();
     } else {
         $(target).removeClass('open');
         $(target).addClass('closed');

         $(target).children('.row-wrapper').slideUp();
     }
 }

 // The function actually applying the offset
 function offsetAnchor() {
     var headerHeight = $(".skeleton--header").outerHeight();
     if (location.hash.length !== 0) {
         window.scrollTo(window.scrollX, window.scrollY - (headerHeight + 10));
     }
 }

 // This will capture hash changes while on the page
 window.addEventListener("hashchange", offsetAnchor);