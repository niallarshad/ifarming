/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2014-04-15 19:10:39 UTC)
 * on 2014-05-13 at 13:39:14 UTC 
 * Modify at your own risk.
 */

package com.farming.app.frontEnd.questionsendpoint;

/**
 * Service definition for Questionsendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link QuestionsendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Questionsendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the questionsendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://farmsocialapp.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "questionsendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Questionsendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Questionsendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getQuestions".
   *
   * This request holds the parameters needed by the the questionsendpoint server.  After setting any
   * optional parameters, call the {@link GetQuestions#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetQuestions getQuestions(java.lang.String id) throws java.io.IOException {
    GetQuestions result = new GetQuestions(id);
    initialize(result);
    return result;
  }

  public class GetQuestions extends QuestionsendpointRequest<com.farming.app.frontEnd.questionsendpoint.model.Questions> {

    private static final String REST_PATH = "questions/{id}";

    /**
     * Create a request for the method "getQuestions".
     *
     * This request holds the parameters needed by the the questionsendpoint server.  After setting
     * any optional parameters, call the {@link GetQuestions#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetQuestions#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetQuestions(java.lang.String id) {
      super(Questionsendpoint.this, "GET", REST_PATH, null, com.farming.app.frontEnd.questionsendpoint.model.Questions.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetQuestions setAlt(java.lang.String alt) {
      return (GetQuestions) super.setAlt(alt);
    }

    @Override
    public GetQuestions setFields(java.lang.String fields) {
      return (GetQuestions) super.setFields(fields);
    }

    @Override
    public GetQuestions setKey(java.lang.String key) {
      return (GetQuestions) super.setKey(key);
    }

    @Override
    public GetQuestions setOauthToken(java.lang.String oauthToken) {
      return (GetQuestions) super.setOauthToken(oauthToken);
    }

    @Override
    public GetQuestions setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetQuestions) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetQuestions setQuotaUser(java.lang.String quotaUser) {
      return (GetQuestions) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetQuestions setUserIp(java.lang.String userIp) {
      return (GetQuestions) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetQuestions setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetQuestions set(String parameterName, Object value) {
      return (GetQuestions) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertQuestions".
   *
   * This request holds the parameters needed by the the questionsendpoint server.  After setting any
   * optional parameters, call the {@link InsertQuestions#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.farming.app.frontEnd.questionsendpoint.model.Questions}
   * @return the request
   */
  public InsertQuestions insertQuestions(com.farming.app.frontEnd.questionsendpoint.model.Questions content) throws java.io.IOException {
    InsertQuestions result = new InsertQuestions(content);
    initialize(result);
    return result;
  }

  public class InsertQuestions extends QuestionsendpointRequest<com.farming.app.frontEnd.questionsendpoint.model.Questions> {

    private static final String REST_PATH = "questions";

    /**
     * Create a request for the method "insertQuestions".
     *
     * This request holds the parameters needed by the the questionsendpoint server.  After setting
     * any optional parameters, call the {@link InsertQuestions#execute()} method to invoke the remote
     * operation. <p> {@link InsertQuestions#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.farming.app.frontEnd.questionsendpoint.model.Questions}
     * @since 1.13
     */
    protected InsertQuestions(com.farming.app.frontEnd.questionsendpoint.model.Questions content) {
      super(Questionsendpoint.this, "POST", REST_PATH, content, com.farming.app.frontEnd.questionsendpoint.model.Questions.class);
    }

    @Override
    public InsertQuestions setAlt(java.lang.String alt) {
      return (InsertQuestions) super.setAlt(alt);
    }

    @Override
    public InsertQuestions setFields(java.lang.String fields) {
      return (InsertQuestions) super.setFields(fields);
    }

    @Override
    public InsertQuestions setKey(java.lang.String key) {
      return (InsertQuestions) super.setKey(key);
    }

    @Override
    public InsertQuestions setOauthToken(java.lang.String oauthToken) {
      return (InsertQuestions) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertQuestions setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertQuestions) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertQuestions setQuotaUser(java.lang.String quotaUser) {
      return (InsertQuestions) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertQuestions setUserIp(java.lang.String userIp) {
      return (InsertQuestions) super.setUserIp(userIp);
    }

    @Override
    public InsertQuestions set(String parameterName, Object value) {
      return (InsertQuestions) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listQuestions".
   *
   * This request holds the parameters needed by the the questionsendpoint server.  After setting any
   * optional parameters, call the {@link ListQuestions#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListQuestions listQuestions() throws java.io.IOException {
    ListQuestions result = new ListQuestions();
    initialize(result);
    return result;
  }

  public class ListQuestions extends QuestionsendpointRequest<com.farming.app.frontEnd.questionsendpoint.model.CollectionResponseQuestions> {

    private static final String REST_PATH = "questions";

    /**
     * Create a request for the method "listQuestions".
     *
     * This request holds the parameters needed by the the questionsendpoint server.  After setting
     * any optional parameters, call the {@link ListQuestions#execute()} method to invoke the remote
     * operation. <p> {@link ListQuestions#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected ListQuestions() {
      super(Questionsendpoint.this, "GET", REST_PATH, null, com.farming.app.frontEnd.questionsendpoint.model.CollectionResponseQuestions.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListQuestions setAlt(java.lang.String alt) {
      return (ListQuestions) super.setAlt(alt);
    }

    @Override
    public ListQuestions setFields(java.lang.String fields) {
      return (ListQuestions) super.setFields(fields);
    }

    @Override
    public ListQuestions setKey(java.lang.String key) {
      return (ListQuestions) super.setKey(key);
    }

    @Override
    public ListQuestions setOauthToken(java.lang.String oauthToken) {
      return (ListQuestions) super.setOauthToken(oauthToken);
    }

    @Override
    public ListQuestions setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListQuestions) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListQuestions setQuotaUser(java.lang.String quotaUser) {
      return (ListQuestions) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListQuestions setUserIp(java.lang.String userIp) {
      return (ListQuestions) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListQuestions setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListQuestions setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListQuestions set(String parameterName, Object value) {
      return (ListQuestions) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeQuestions".
   *
   * This request holds the parameters needed by the the questionsendpoint server.  After setting any
   * optional parameters, call the {@link RemoveQuestions#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveQuestions removeQuestions(java.lang.String id) throws java.io.IOException {
    RemoveQuestions result = new RemoveQuestions(id);
    initialize(result);
    return result;
  }

  public class RemoveQuestions extends QuestionsendpointRequest<Void> {

    private static final String REST_PATH = "questions/{id}";

    /**
     * Create a request for the method "removeQuestions".
     *
     * This request holds the parameters needed by the the questionsendpoint server.  After setting
     * any optional parameters, call the {@link RemoveQuestions#execute()} method to invoke the remote
     * operation. <p> {@link RemoveQuestions#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveQuestions(java.lang.String id) {
      super(Questionsendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveQuestions setAlt(java.lang.String alt) {
      return (RemoveQuestions) super.setAlt(alt);
    }

    @Override
    public RemoveQuestions setFields(java.lang.String fields) {
      return (RemoveQuestions) super.setFields(fields);
    }

    @Override
    public RemoveQuestions setKey(java.lang.String key) {
      return (RemoveQuestions) super.setKey(key);
    }

    @Override
    public RemoveQuestions setOauthToken(java.lang.String oauthToken) {
      return (RemoveQuestions) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveQuestions setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveQuestions) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveQuestions setQuotaUser(java.lang.String quotaUser) {
      return (RemoveQuestions) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveQuestions setUserIp(java.lang.String userIp) {
      return (RemoveQuestions) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveQuestions setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveQuestions set(String parameterName, Object value) {
      return (RemoveQuestions) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateQuestions".
   *
   * This request holds the parameters needed by the the questionsendpoint server.  After setting any
   * optional parameters, call the {@link UpdateQuestions#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.farming.app.frontEnd.questionsendpoint.model.Questions}
   * @return the request
   */
  public UpdateQuestions updateQuestions(com.farming.app.frontEnd.questionsendpoint.model.Questions content) throws java.io.IOException {
    UpdateQuestions result = new UpdateQuestions(content);
    initialize(result);
    return result;
  }

  public class UpdateQuestions extends QuestionsendpointRequest<com.farming.app.frontEnd.questionsendpoint.model.Questions> {

    private static final String REST_PATH = "questions";

    /**
     * Create a request for the method "updateQuestions".
     *
     * This request holds the parameters needed by the the questionsendpoint server.  After setting
     * any optional parameters, call the {@link UpdateQuestions#execute()} method to invoke the remote
     * operation. <p> {@link UpdateQuestions#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.farming.app.frontEnd.questionsendpoint.model.Questions}
     * @since 1.13
     */
    protected UpdateQuestions(com.farming.app.frontEnd.questionsendpoint.model.Questions content) {
      super(Questionsendpoint.this, "PUT", REST_PATH, content, com.farming.app.frontEnd.questionsendpoint.model.Questions.class);
    }

    @Override
    public UpdateQuestions setAlt(java.lang.String alt) {
      return (UpdateQuestions) super.setAlt(alt);
    }

    @Override
    public UpdateQuestions setFields(java.lang.String fields) {
      return (UpdateQuestions) super.setFields(fields);
    }

    @Override
    public UpdateQuestions setKey(java.lang.String key) {
      return (UpdateQuestions) super.setKey(key);
    }

    @Override
    public UpdateQuestions setOauthToken(java.lang.String oauthToken) {
      return (UpdateQuestions) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateQuestions setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateQuestions) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateQuestions setQuotaUser(java.lang.String quotaUser) {
      return (UpdateQuestions) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateQuestions setUserIp(java.lang.String userIp) {
      return (UpdateQuestions) super.setUserIp(userIp);
    }

    @Override
    public UpdateQuestions set(String parameterName, Object value) {
      return (UpdateQuestions) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Questionsendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Questionsendpoint}. */
    @Override
    public Questionsendpoint build() {
      return new Questionsendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link QuestionsendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setQuestionsendpointRequestInitializer(
        QuestionsendpointRequestInitializer questionsendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(questionsendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
