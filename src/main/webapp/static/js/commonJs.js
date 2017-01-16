/**
 * Created by Administrator on 2017/1/16.
 */
function getBasePath() {
    var obj = window.location;
    var contextPath = obj.pathname.split("/")[0];
    return obj.protocol + "//" + obj.host + "/" + contextPath;
}