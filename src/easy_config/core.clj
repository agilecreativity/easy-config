(ns easy-config.core
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as string]
            [me.raynes.fs :as fs])
  (:gen-class))

(defn- exit [status msg]
  (println msg)
  (System/exit status))

(defn- read-config
  [filename]
  (let [file-path (-> filename
                      fs/expand-home
                      fs/normalized)]
    (if (fs/exists? file-path)
      (edn/read-string (slurp file-path))
      (exit 1 (str "Invalid config file :" file-path)))))

(defn- lookup-config
  "Find and return the first matching config entry by a given id"
  [filename label]
  (filter #(= (:id %) label) (read-config filename)))

;; Load config from a given file
(defn load-config
  "Load the config having a given id from a given config-file"
  [config-file id]
  (first (lookup-config config-file id)))
