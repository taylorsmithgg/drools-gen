/*   Copyright 2016 Drools Fiddle

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.droolsfiddle.rest;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jvipret on 08/06/2016.
 */
@ApplicationPath("")
public class RESTApplication extends javax.ws.rs.core.Application {
  private Set<Object> singletons = new HashSet<Object>();
  private HashSet<Class<?>> classes = new HashSet<Class<?>>();

  public RESTApplication() {
    CorsFilter corsFilter = new CorsFilter();
    corsFilter.getAllowedOrigins().add("*");
    corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
    singletons.add(corsFilter);
  }

  @Override
  public Set<Object> getSingletons() {
    return singletons;
  }

  @Override
  public HashSet<Class<?>> getClasses(){
    return classes;
  }
}
