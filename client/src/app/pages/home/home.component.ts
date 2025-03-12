import {Component, OnInit} from '@angular/core';
import {ChatListService} from '../../services/chat-list.service';
import {NavbarComponent} from '../components/navbar/navbar.component';

@Component({
  selector: 'app-home',
  imports: [
    NavbarComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  constructor(private readonly chatListService: ChatListService) {}

  ngOnInit(): void {
    this.fetchChatList();
  }

  private fetchChatList(): void {
    this.chatListService.getChatList().subscribe({
      next: (res) => {
        console.log(res)
      },
      error: (err) => {
        console.error(err)
      }
    })
  }

}
