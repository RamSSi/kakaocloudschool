import React, { Component } from "react";
import "./App.css"

export default class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      todoData: [
        {
          id: "1",
          title: "운동하기",
          completed: false
        },
        {
          id: "2",
          title: "공부하기",
          completed: false
        },
        {
          id: "3",
          title: "밥먹기",
          completed: false
        }
      ]
    }
  }

  btnStyle = {
    color: "gray",
    border: "none",
    padding: "5px 9px",
    borderRadius: "15px",
    cursor: "pointer",
    float: "right"
  }

  getStyle = () => {
    return {
      padding: "20px",
      borderBottom: "1px #ccc dotted",
      textDecoration: "none"
    }
  }

  deleteClick = (id) => {
    const newTodoData = this.state.todoData.filter(data => data.id !== id);
    
    this.setState({todoData: newTodoData});

  }

  handleChange = (e) => {
    console.log(e.target.value);
    this.setState({ value: e.target.value });
  }

  render() {
    return (
      <div className="container">
        <div className="todoBlock">
          <div>
            <h1>To Do</h1>
          </div>

          {this.state.todoData.map(data => (
            <div style={this.getStyle()} key={data.id}>
              <input type="checkbox" defaultChecked={false} />
              {data.title}
              <button style={this.btnStyle} onClick={() => this.deleteClick(data.id)}>delete</button>

            </div>
          ))}

          <form style={{ display: "flex"}}>
            <input type="text" 
                   name="todoInput" 
                   style={{ flex: "10", padding: "5px" }}
                   placeholder="New Todo"
                   value={this.state.value}
                   onChange={this.handleChange} />
            <input type="submit"
                   value="입력"
                   className="btn"
                   style={{ flex: "1" }} />

          </form>
          
        </div>
      </div>
    );
  }
}