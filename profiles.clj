{:user {:plugins [[cider/cider-nrepl "0.8.1"]
                  [lein-kibit "0.1.2"]
                  [org.clojure/tools.trace "0.7.8"]
                  [org.clojure/tools.namespace "0.2.11"]

                  ;; Find out what these are
                  ;; "http://jakemccrary.com/blog/2015/01/11/
                  ;;   overview-of-my-leiningen-profiles-dot-clj/"                  
                  [jonase/eastwood "0.2.1"]

                  ;; See this: https://github.com/clojure-emacs/clj-refactor.el
                  [refactor-nrepl "1.1.0"]
                  [lein-midje "3.1.3"]
                  [lein-pprint "1.1.2"]
                  [com.jakemccrary/lein-test-refresh "0.5.5"]
                  [lein-autoexpect "1.4.2"]
                  [lein-ancient "0.5.5"]]}}


;; Jake-something's  user profile.
#_
{:user {:plugin-repositories [["private-plugins" {:url "private repo url"}]]
        :dependencies [[pjstadig/humane-test-output "0.6.0"]]
        
        :injections [(require 'pjstadig.humane-test-output)
                     (pjstadig.humane-test-output/activate!)]
        :plugins [[cider/cider-nrepl "0.9.1"]
                  [refactor-nrepl "1.1.0"]
                  [com.jakemccrary/lein-test-refresh "0.5.5"]
                  [lein-autoexpect "1.4.2"]
                  [lein-ancient "0.5.5"]
                  [jonase/eastwood "0.2.1"]
                  [lein-kibit "0.0.8"]
                  [lein-pprint "1.1.2"]]
        :test-refresh {:notify-command
                       ["terminal-notifier" "-title" "Tests" "-message"]}}}

#_ ;; A scarier profile.
{:user 
  {:plugins [...]        
   :dependencies [[spyscope "0.1.4"]
                  [org.clojure/tools.namespace "0.2.4"]
                  [leiningen #=(leiningen.core.main/leiningen-version)]
                  [io.aviso/pretty "0.1.8"]
                  [im.chit/vinyasa "0.3.4"]]
   :injections 
   [(require 'spyscope.core)
    (require '[vinyasa.inject :as inject])
    (require 'io.aviso.repl)
    (inject/in ;; the default injected namespace is `.` 

               ;; note that `:refer, :all and :exclude can be used
               [vinyasa.inject :refer [inject [in inject-in]]]  
               [vinyasa.lein :exclude [*project*]]  

               ;; imports all functions in vinyasa.pull
               [vinyasa.pull :all]      

               ;; same as [cemerick.pomegranate 
               ;;           :refer [add-classpath get-classpath resources]]
               [cemerick.pomegranate add-classpath get-classpath resources] 

               ;; inject into clojure.core 
               clojure.core
               [vinyasa.reflection .> .? .* .% .%> .& .>ns .>var]

               ;; inject into clojure.core with prefix
               clojure.core >
               [clojure.pprint pprint]
               [clojure.java.shell sh])}}
