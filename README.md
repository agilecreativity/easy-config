# easy-config

[![Clojars Project](https://img.shields.io/clojars/v/easy-config.svg)](https://clojars.org/easy-config)
[![Dependencies Status](https://jarkeeper.com/agilecreativity/easy-config/status.svg)](https://jarkeeper.com/agilecreativity/easy-config)

A Clojure library designed to load simple config in the edn format.

## Usage

- Leiningen

```
[easy-config "0.1.1"]
```

Example Usage:

```clojure
# from `core.clj`
(defn load-config
  "Load the config having a given id from a given config-file"
  [id config-file]
  (first (lookup-config id config-file)))
```

Just call `(load-config "./sample-config.edn" "github")`

### Sample config file in edn format

```clojure
[{:id "github"
  :site-url "https://github.com/login"
  :username "awesome_dev"
  :password "SECRET-PASSWORD"}
 {:id "github-work"
  :site-url "https://github.com/login"
  :username "awesome-coder"
  :password "EVENT-MORE-SECRET"}]
```

## License

Copyright © 2016 Burin Choomnuan

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
