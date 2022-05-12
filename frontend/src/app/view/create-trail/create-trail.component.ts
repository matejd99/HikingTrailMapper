import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TrailService } from 'src/app/service/trail.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-create-trail',
  templateUrl: './create-trail.component.html',
  styleUrls: ['./create-trail.component.css'],
})
export class CreateTrailComponent implements OnInit {
  public trailForm = this.fb.group({
    trailName: [''],
    trailDescription: [''],
    suggestedGear: [''],
    trailLength: [''],
    hikeDuration: [''],
    waterAvailability: [''],
  });

  public trailPath: any;

  private updateTrailId?: number;

  public get isUpdate(): boolean {
    return !!this.updateTrailId;
  }

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private trailService: TrailService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  public onSubmit() {
    if (this.userService.logedInUser) {
      if (this.updateTrailId) {
        this.trailService.updateTrail(
          this.userService.logedInUser?.id,
          this.updateTrailId,
          {
            ...this.trailForm.value,
            path: JSON.stringify(this.trailPath),
          }
        );
      } else {
        this.trailService.postTrail(this.userService.logedInUser?.id, {
          ...this.trailForm.value,
          path: JSON.stringify(this.trailPath),
        });
      }
    } else {
      alert('Not logged in');
    }
  }

  ngOnInit(): void {
    let trailId = this.route.snapshot.queryParams['trailId'];

    if (trailId) {
      this.trailService.getTrail(trailId).subscribe(
        (trail) => {
          this.updateTrailId = trail.id;

          this.trailForm.patchValue({
            trailName: trail.trailName,
            trailDescription: trail.trailDescription,
            suggestedGear: trail.suggestedGear,
            trailLength: trail.trailLength,
            hikeDuration: trail.hikeDuration,
            waterAvailability: trail.waterAvailability,
            path: trail.path,
          });
          this.trailPath = JSON.parse(trail.path);
        },
        (err) => {
          console.error(err);
          alert('Trail not found');
          this.router.navigate(['']);
        }
      );
    }
  }
}
