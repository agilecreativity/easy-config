# easy-config

[![Clojars Project](https://img.shields.io/clojars/v/easy-config.svg)](https://clojars.org/easy-config)
[![Dependencies Status](https://jarkeeper.com/agilecreativity/easy-config/status.svg)](https://jarkeeper.com/agilecreativity/easy-config)

A Clojure library designed to load simple config in the edn format.

## Usage

- Leiningen

```
[easy-config "0.1.2"]
```
### Example Usage:

```clojure
;; To load all config
(all-config "./sample-config.edn")

;; To load the first matching config having a given config-id
(load-config "~/Dropbox/sample-config.edn" "github")
```

### Sample config file in edn format

See [official edn format documentation](https://github.com/edn-format/edn) for detail.

```clojure
[{:id "github"
  :site-url "https://github.com/login"
  :username "awesome_dev"
  :password "SECRET-PASSWORD"}
  :nested-item {:some-key 123, :other-key "abc"}}
 {:id "github-work"
  :site-url "https://github.com/login"
  :username "awesome-coder"
  :password "EVENT-MORE-SECRET"}]
```

## License

Copyright © 2016 Burin Choomnuan

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
