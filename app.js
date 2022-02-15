var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');



var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));


var indexRouter = require('./routes/index');
app.use('/', indexRouter);

var usersRouter = require('./routes/users');
app.use('/users', usersRouter);

var signupRouter = require('./routes/signup');
app.use('/signup', signupRouter);

var testRouter = require('./routes/test');
app.use('/test', testRouter);

var clauseRouter = require('./routes/clause');
app.use('/clause', clauseRouter);

var informationRouter = require('./routes/information');
app.use('/information', informationRouter);

var informationfarmRouter = require('./routes/informationfarm');
app.use('/informationfarm', informationfarmRouter);

var checkfarmRouter = require('./routes/checkfarm');
app.use('/checkfarm', checkfarmRouter);

var checkuserRouter = require('./routes/checkuser');
app.use('/checkuser', checkuserRouter);

var inputprofileRouter = require('./routes/inputprofile');
app.use('/inputprofile', inputprofileRouter);

var location_selectRouter = require('./routes/location_select');
app.use('/location_select', location_selectRouter);

var mainRouter = require('./routes/main');
app.use('/main', mainRouter);


// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
