import { Component, Input, OnInit } from '@angular/core';
import { Comment } from '../../contracts/models';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
})
export class CommentComponent implements OnInit {
  @Input('comment') public comment?: Comment;

  constructor() {}

  ngOnInit(): void {}
}
