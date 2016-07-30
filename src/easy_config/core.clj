(ns easy-config.core
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as string]
            [me.raynes.fs :as fs])
  (:gen-class))

(declare all-config)
(declare load-config)
(declare exit)

(defn- find-by-id
  "Find and return the first matching config entry by a given config-id"
  [filename config-id]
  (filter #(= (:id %) config-id) (all-config filename)))

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn all-config
  "Read and return edn configuration from a given filename"
  [filename]
  (let [file-path (-> filename
                      fs/expand-home
                      fs/normalized)]
    (if (fs/exists? file-path)
      (edn/read-string (slurp file-path))
      (exit 1 (str "Invalid config file :" file-path)))))

(defn load-config
  "Load the config having a given config-id from a given config-file"
  [config-file config-id]
  (first (find-by-id config-file config-id)))
