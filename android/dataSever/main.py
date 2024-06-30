from flask import Flask, render_template, request, url_for, flash, redirect
from werkzeug.security import generate_password_hash, check_password_hash
from flask_login import LoginManager, UserMixin, login_required, logout_user, current_user, login_user
import pymysql
import click



app = Flask(__name__)
app.jinja_env.trim_blocks = True
app.jinja_env.lstrip_blocks = True
app.secret_key = 'xiongzhiyuan'

try:
    db = pymysql.connect(host='localhost',
                         user='root',
                         password='fcy20020624',
                         database='test',
                         charset='utf8',
                         autocommit=False)

    cursor = db.cursor()
except Exception as e:
    print(e)


