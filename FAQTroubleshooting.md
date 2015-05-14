**This page lists all the questions a user may ask about G2Android (with their answers!), including questions such as "It doesn't work with my gallery, what's wrong with it ?"**

## General questions about G2Android features and compatibility ##
> ### Q: Is G2Android compatible with the old Gallery (the first, not Gallery2) or the newer Gallery3 ? ###
A: G2Android has only been tested with Gallery2, not with Gallery 1 (but it should work with it, because the remote API seems to be the same) or Gallery3.
Gallery 3 is now using another remote API, based on REST; which means all the connection layer must be upfated in order to make g2android with G3, I shall work on this during this summer 2010

> ### Q: I know a bit of Java and Android development, or I want to translate the application in my language, how can I help ? ###
A: You can contact me, the project owner, anthony.dahanne at gmail.com, and I'll create you a contributor account on the project. If you want to translate, G2Android is i18n compliant, so you can already translate the values in [the strings file](http://code.google.com/p/g2android/source/browse/trunk/g2android/res/values/strings.xml) and send me by mail your translation.


---

## G2Android does not work with my gallery ##
> ### Q: G2Android works fine with the default demo Gallery, but not with mine ###
A: The most typical reason is because you did not activate the Gallery Remote Module in your gallery ( [Gallery Remote Module page](http://codex.gallery2.org/Gallery2:Modules:remote)). Without it activated, you won't get G2Android working on your gallery

> ### Q: My gallery is password protected on album level and not on user level ([gallery password module](http://codex.gallery2.org/Gallery2:Modules:password)), can G2Android list and display such albums ? ###
A: I don't think so, it has been reported no to work, and the Gallery Remote Api page does not mention how to list such albums (maybe I'm wrong ?)

> ### Q: My gallery has the Remote Module activated, is not protected  on the album level, but G2android still can't connect to it ###
A: It may be a bug, please report it on this page http://code.google.com/p/g2android/issues/list, it will be taken care of