import React from 'react';
import $ from "jquery";

class Login extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            email: '',
            pass: '',
        };

        this.handleEmail = this.handleEmail.bind(this);
        this.handlePass = this.handlePass.bind(this);
        this.handleJoin = this.handleJoin.bind(this);
        this.request = this.request.bind(this);
    }

    handleEmail(event) {
        this.setState({
            email: event.target.value
        });
    }

    handlePass(event) {
        this.setState({
            pass: event.target.value
        });
    }

    handleJoin(data) {
        alert(data);
        const error = data.error;
        const response = data.response;

        if (error) {
            alert(error.detailMessage);
        } else {
            alert(response);
            this.props.joinFunction();
        }
    }

    request() {
        $.ajax({
            method: "POST",
            url: "/join",
            data: JSON.stringify({email: this.state.email, pass: this.state.pass}),
            success: function(data) {
                this.handleJoin(data);
            }.bind(this),
            error: function(xhr, status, err) {
                alert(status + " " + err.toString());
            }
        })

    }

    render() {
        return (
            <div className="container formDiv">
                <form>
                    <label className="sr-only">Email</label>
                    <input type="email" className="form-control" placeholder={'Enter email'}
                           onChange={this.handleEmail}/>
                    <label className="sr-only">Password</label>
                    <input type="password" className="form-control" placeholder={'Enter password'}
                           onChange={this.handlePass}/>
                </form>
                <button className="btn btn-lg btn-success btn-block" onClick={this.request}>Sign Up</button>
                <p className="text-center">Join us now</p>
            </div>
        );
    };
}

export default Login;