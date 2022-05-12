import { AfterViewInit, Component, Input, OnInit } from '@angular/core';
import { Trail } from 'src/app/contracts/models';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'trail-item',
  templateUrl: './trail-item.component.html',
  styleUrls: ['./trail-item.component.css'],
})
export class TrailItemComponent implements OnInit {
  @Input('trail') public trail?: Trail;

  public trailPath: any;
  public canEdit: boolean = false;

  public get queryParams() {
    return {
      trailId: this.trail?.id,
    };
  }

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    if (this.trail?.path) this.trailPath = JSON.parse(this.trail?.path);

    this.canEdit = this.userService.logedInUser?.id === this.trail?.user?.id;
  }
}
