import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Trail, Comment } from 'src/app/contracts/models';
import { CommentService } from 'src/app/service/comment.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'trail-item',
  templateUrl: './trail-item.component.html',
  styleUrls: ['./trail-item.component.css'],
})
export class TrailItemComponent implements OnInit {
  @Input('trail') public trail?: Trail;

  public commentForm = this.fb.group({
    comment: [''],
  });

  public trailPath: any;
  public canEdit: boolean = false;

  public get queryParams() {
    return {
      trailId: this.trail?.id,
    };
  }

  constructor(
    private userService: UserService,
    private fb: FormBuilder,
    private commentService: CommentService
  ) {}

  public createComment() {
    if (this.userService.logedInUser && this.trail) {
      this.commentService
        .createComment(
          this.userService.logedInUser.id,
          this.trail.id,
          this.commentForm.value
        )
        .then((comment) => {
          this.trail?.comments?.push(comment);
        });
    }
  }

  ngOnInit(): void {
    if (this.trail?.path) this.trailPath = JSON.parse(this.trail?.path);

    this.canEdit = this.userService.logedInUser?.id === this.trail?.user?.id;
  }
}
