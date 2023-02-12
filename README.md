**This is not an official Google product**

# Run

_I'm going to be a really good runner. I just need to finish this app..._

## Requirements
Create an application on Strava (https://www.strava.com/settings/api). "Authorization Callback Domain" should be `wear.googleapis.com`.

`~/.gradle/gradle.properties`:

```
# https://www.strava.com/settings/api
STRAVA_RUN_CLIENT_ID="YOUR_CLIENT_ID"
STRAVA_RUN_CLIENT_SECRET="YOUR_CLIENT_SECRET"
```

## Screens
### Pre-run screen
- start run button
- last activity (if any)
- connect(/ed) to Strava

### Run screen
### Completed activity screen
This is shown when the user has confirmed they want to end an activity.
