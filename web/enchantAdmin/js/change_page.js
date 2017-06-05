/**
 * 页面切换控制
 * @param {Object} objActive
 * @param {Object} pageIndex
 */

function changePage(objActive,pageIndex) {
          var arrActivePage = document.getElementsByClassName('active');
          var activePage;
          for(var i=0;i<arrActivePage.length;i++) {
              if(arrActivePage[i].className.indexOf("page") > -1){
                  activePage = arrActivePage[i];
              }
          }
          if(objActive == activePage){
              return;
          }
          activePage.className = activePage.className.replace(/active/," ");
          if(activePage.className.indexOf("dropdown-li") > -1) {
              var dropdownClassName = activePage.parentNode.parentNode.className;
              activePage.parentNode.parentNode.className = dropdownClassName.replace(/active/," ");
          }
          
          objActive.className += " active ";
          if(objActive.className.indexOf("dropdown-li") > -1) {
              objActive.parentNode.parentNode.className += " active ";
          }
          //$("#page-content")
          switch(pageIndex){
              case 1:
                $("#page-content").load("page/home.html");
                break;
              case 2:
                $("#page-content").load("page/notice.html");
                break;
              case 3:
                $("#page-content").load("page/feedback.html");
                break;
              case 4:
                $("#page-content").load("page/music_list.html");
                break;
              case 5:
                $("#page-content").load("page/music_upload.html");
                break;
              case 6:
                $("#page-content").load("page/notice.html");
                break;
              case 7:
                $("#page-content").load("page/notice.html");
                break;
              case 8:
                $("#page-content").load("page/notice.html");
                break;
              default:
                break;
          }
}

function switchPage(strHash) {
    var strHash = strHash.substring(1);
    var arrPage = [];
    var strRootPath = "page/";
    switch(strHash){
        case "home":
            arrPage['page_file'] = strRootPath + "home.html";
            arrPage['page_num'] = 1;
            arrPage['li_id'] = "page-home";
            break;
        case "notice":
            arrPage['page_file'] = strRootPath + "notice.html";
            arrPage['page_num'] = 2;
            arrPage['li_id'] = "page-notice";
            break;
        case "feedback":
            arrPage['page_file'] = strRootPath + "feedback.html";
            arrPage['page_num'] = 3;
            arrPage['li_id'] = "page-feedback";
            break;
        case "music-list":
            arrPage['page_file'] = strRootPath + "music_list.html";
            arrPage['page_num'] = 4;
            arrPage['li_id'] = "page-music-list";
            break;
        case "music-upload":
            arrPage['page_file'] = strRootPath + "music_upload.html";
            arrPage['page_num'] = 5;
            arrPage['li_id'] = "page-music-upload";
            break;
        case "user-info":
            arrPage['page_file'] = strRootPath + "user_info.html";
            arrPage['page_num'] = 6;
            arrPage['li_id'] = "page-user-info";
            break;
        case "user-manage":
            arrPage['page_file'] = strRootPath + "user_manage.html";
            arrPage['page_num'] = 7;
            arrPage['li_id'] = "page-user-manage";
            break;
        case "user-push":
            arrPage['page_file'] = strRootPath + "user_push.html";
            arrPage['page_num'] = 8;
            arrPage['li_id'] = "page-user-push";
            break;
        default:
            arrPage['page_file'] = strRootPath + "home.html";
            arrPage['page_num'] = 1;
            arrPage['li_id'] = "page-home";
            break;
    }
    return arrPage;
}
