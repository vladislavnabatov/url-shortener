# url-shortener

A [re-frame](https://github.com/Day8/re-frame) application designed to shorten urls.

## Prerequisites

Clojure [https://clojure.org/guides/getting_started]
Leiningen [https://leiningen.org/#install]

## Development Mode

### Run application:

```
lein deps
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

### Run tests:

Install karma and headless chrome

```
npm install -g karma-cli
npm install karma karma-cljs-test karma-chrome-launcher --save-dev
```

And then run your tests

```
lein clean
lein doo chrome-headless test once
```

Please note that [doo](https://github.com/bensu/doo) can be configured to run cljs.test in many JS environments (phantom, chrome, ie, safari, opera, slimer, node, rhino, or nashorn).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
