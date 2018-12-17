This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br>
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br>
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br>
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br>
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br>
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

**Note:** this will not affect translation. You must run the translations scripts separately. This will build the translations as they currently exist.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (Webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

**Further Note: don't do this**

I'm not kidding, don't eject, unless you're willing to be solely responsible for learning, configuring, and endlessly fiddling with a huge pile of build tools. If your dependency doesn't support CRA, I promise you somebody has or will make a CRA version of it.

Don't eject.

## Internationalization

The translation files are managed in `/src/i18n/locales` and `/src/i18n/messages`. All translations are committed to source control, and while the following operations are destructive to files, they are "safe" in the sense that if the changes don't work out, you can revert to an earlier commit.

The translations themselves are managed in `messages/messages.json` and `locales/en.json`, `locales/es.json`, and so on. The `messages.json` is a dictionary for all named messages in the source code. The `locales/[language].json` files contain those languages' translations of the text for that key. The json files in `locales` are read directly by the application and can (and must) be translated directly.

That being said there are several scripts which help manage these files:

### `npm run extract:transations`

Literally just runs `/translationRunner.js`.

This will examine the code for usages of `defineMessages` from `react-intl`, and create a skeleton of messages in `/src/i18n/messages/messages.json`. This json contains the full list of all i18n-ready messages in the application, including their ids, where they were originally defined, and what their default message is (if the translated version is not available).

**Note:** if you remove a message from the application, it will also remove it from this skeleton. That is, it is a pure create, not an addition or modifier.

**Note:** This does not affect what is shown in the application; it is purely used as a first stage of the translation process.

### `npm run manage:translations`

This will use `/src/i18n/messages/messages.json` and the languages list in `/translationRunner.js` to appropriately modify the appropriate translation files in `i18n/locales`. This has the following effects:

- If a new language is added to `/translationRunner.js` (e.g. `"ar"`), a default translation will appear in `/src/i18n/locales/` (e.g. `"ar.json"` and `"whitelist_ar.json"`). Each message will be represented as the default message.
- If a new message is added to `messages.json` (usually by running the `extract:translations` script), it will be populated in all of the existing or new translation files, with the default value of that message.
- If a message is removed from `messages.json`, it will be removed from all the translation files.
- If a language is removed from `/translationRunner.js`, the files will _not_ be removed, but they will also not be checked for completeness (they will simply be ignored by the script).
- Any key in the translation which already existed will be unchanged (assuming the key is still in `messages.json`).

Additionally after the script is run, any tracked files will be checked:

- If a key appears more than once, this script will output an error (this is important and needs to be fixed).
- If a key's value is equal to the defaultMessage, this script will output an error (this is considered an un-translated key; in the application, the default value will be shown).

One thing this script does _not_ maintain is `/src/i18n/locales/index.js`. If a new language is added, (e.g. `"ar"`) then `index.js` must be modified. For example, if adding `"ar"`, the file will need `import ar from './ar.json` and last line will need to be modified to `export default { en, es, ar };` or etc.

This `index.js` is read by the application; therefore any modifications to the `json` files will be used immediately in the application.

### `npm run update:translations`

This is equivalent to running `extract:messages` and then `manage:translations`; that is, it will extract messages from the source code and modify the translations appropriately, including checking messages.
