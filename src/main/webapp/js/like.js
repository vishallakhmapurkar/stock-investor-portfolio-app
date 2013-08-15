function social_media_buttons(site,text,page) {
    // First, check if 'social-media-buttons' div exists...
    if ($('#social-media-buttons').length) {

        // Create Twitter button
        $('#social-media-buttons').append('<div id="twitter-button"></div>');
        $('#twitter-button').attr("style","float: left;");
        $('#twitter-button').append('<iframe id="share-twitter"></iframe>');
        var twitter = $('iframe#share-twitter');
        twitter.attr("title", "Twitter Tweet Button");
        twitter.attr("frameBorder", "0");
        twitter.attr("scrolling", "no");
        twitter.attr("marginWidth", "0");
        twitter.attr("marginHeight", "0");
        twitter.attr("allowtransparency", "true");
        twitter.attr("vspace", "0");
        twitter.attr("hspace", "0");
        twitter.attr("tabindex", "-1");
        twitter.attr("style","width: 55px; height: 62px;");
        var src = 'http://platform.twitter.com/widgets/tweet_button.html?count=vertical';
        src = src + '&enableNewSizing=false&lang=en&original_referer=' + site;
        src = src + '&size=m&text=' + encodeURI(text) + '&url=' + page;
        twitter.attr("src", src);

        /**
        $('#social-media-buttons').append('<div id="google-button"></div>');
        $('#google-button').attr("style","float: left; margin: 2px 8px;");
        $('#google-button').append('<iframe id="share-google"></iframe>');
        var google = $('iframe#share-google');
        google.attr("title", "Google +1 Button");
        google.attr("frameBorder", "0");
        google.attr("scrolling", "no");
        google.attr("marginWidth", "0");
        google.attr("marginHeight", "0");
        google.attr("allowtransparency", "true");
        google.attr("vspace", "0");
        google.attr("hspace", "0");
        google.attr("tabindex", "-1");
        google.attr("style","width: 50px; height: 62px;");
        var src = 'https://plusone.google.com/_/+1/fastbutton?url=' + page;
        src = src + '&useSharedProxy=true&rcache=true&scache=true&size=tall';
        src = src + '&count=true&hl=en-US&parent=' + site;
        google.attr("src", src);**/

        // Create Facebook button
        $('#social-media-buttons').append('<div id="facebook-button"></div>');
        $('#facebook-button').attr("style","float: left;");
        $('#facebook-button').append('<iframe id="share-facebook"></iframe>');
        var facebook = $('iframe#share-facebook');
        facebook.attr("title", "Facebook Like Button");
        facebook.attr("frameBorder", "0");
        facebook.attr("scrolling", "no");
        facebook.attr("marginWidth", "0");
        facebook.attr("marginHeight", "0");
        facebook.attr("allowtransparency", "true");
        facebook.attr("vspace", "0");
        facebook.attr("hspace", "0");
        facebook.attr("tabindex", "-1");
        facebook.attr("style","width: 60px; height: 62px;");
        var src = 'http://www.facebook.com/plugins/like.php?action=like&href=' + page;
        src = src + '&layout=box_count&show_faces=false&width=450&colorscheme=light';
        facebook.attr("src", src);
    }
}