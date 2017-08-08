/********* score.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface score : CDVPlugin {
  // Member variables go here.
}

- (void)toScore:(CDVInvokedUrlCommand*)command;
@end

@implementation score

- (void)toScore:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [command.arguments objectAtIndex:0];

    NSString  * nsStringToOpen = [NSString  stringWithFormat: @"itms-apps://itunes.apple.com/app/id%@?action=write-review",@"1257685721"];//替换为对应的APPID
    [[UIApplication sharedApplication] openURL:[NSURL URLWithString:nsStringToOpen]];

    if (echo != nil && [echo length] > 0) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
