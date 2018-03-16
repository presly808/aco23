import React from 'react';

class Table extends React.Component {
    render() {
        return (
            <div className="container">
                <table className="table table-condensed table-hover">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Status</th>
                        <th>Price</th>
                        <th>Created</th>
                        <th>Finished</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
                <button className="btn btn-lg btn-success btn-block" onClick={this.props.refreshFunction}>
                    Refresh
                </button>
            </div>
        );
    };
}

export default Table;