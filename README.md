# League map inator thing
When playing on an ultrawide monitor, the minimap is so far to the edge of your screen that checking your minimap once every 2 to 3 seconds ends up straining your neck.

This software images your minimap once every 12 ms and displays the capture in a JFrame. The frame is set to always be on top of other windows. As long as you're playing in borderless/windowed, you'll be able to drag the frame wherever you want on your screen, effectively adding functionality to the game that arguably should be native to the game itself.

Currently the resolution is hard coded to only support 5120x1440, but you can change it easily on line 8 of `App.java`.

> Note that if changing the resolution, there's a chance you will also need to adjust the third and fourth values in that `Rectangle` definition. Those values being `width` and `height` respectively.


<hr>

## Example

![Example](https://media.discordapp.net/attachments/806715624377155625/954364980252250182/unknown.png?width=1693&height=476)